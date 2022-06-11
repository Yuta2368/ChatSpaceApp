package controllers.topics;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Topic;
import models.User;
import utils.JPAUtil;
import validations.TopicValidator;

/**
 * Servlet implementation class TopicsCreate
 */
@WebServlet("/topics/create")
public class TopicsCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = request.getParameter("_token");
		
		if(_token != null && _token.equals(request.getSession().getId())) {
			EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			Topic t = new Topic();
			
			t.setTitle(request.getParameter("title"));
			t.setDescription(request.getParameter("description"));
			t.setCommentNum(0);
			t.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			t.setUser((User)request.getSession().getAttribute("user"));
			
			List<String> errors = TopicValidator.validate(t);
			if(errors.size() > 0) {
				entityManager.close();
				
				request.setAttribute("_token", request.getSession().getId());
				request.setAttribute("topic", t);
				request.setAttribute("errors", errors);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topics/new.jsp");
                rd.forward(request, response);
			} else {
				entityManager.getTransaction().begin();
				entityManager.persist(t);
				entityManager.getTransaction().commit();
				entityManager.close();
				
				response.sendRedirect(request.getContextPath() + "/topics/index");
			}			
		} else {
			System.err.println("Invalid _token");
		}
	}

}
