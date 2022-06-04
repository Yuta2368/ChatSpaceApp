package controllers.topics;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import models.Topic;
import utils.JPAUtil;

/**
 * Servlet implementation class Show
 */
@WebServlet("/topics/show")
public class TopicsShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Topic topic = entityManager.find(Topic.class, id);
		List<Comment> comments = entityManager.createQuery("SELECT c FROM Comment c where c.topic = :topic", Comment.class)
				.setParameter("topic", topic)
				.getResultList();
		
		entityManager.close();
		
		request.setAttribute("comments", comments);
		request.setAttribute("topic", topic);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topics/show.jsp");
        rd.forward(request, response);
	}

}
