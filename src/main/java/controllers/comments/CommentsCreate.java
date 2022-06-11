package controllers.comments;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import models.Topic;
import models.User;
import utils.JPAUtil;
import validations.CommentValidator;

/**
 * Servlet implementation class CommentsCreate
 */
@WebServlet("/comments/create")
public class CommentsCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = request.getParameter("_token");
		
		if(_token != null && _token.equals(request.getSession().getId())) {
			EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			Comment c = new Comment();
			Topic t = entityManager.find(Topic.class, Integer.parseInt(request.getParameter("topicId")));
			User u = entityManager.find(User.class, 1);
			
			t.setCommentNum(t.getCommentNum() + 1);
			c.setTopic(t);
			c.setUser(u);
			c.setContent(request.getParameter("content"));
			c.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			
			List<String> errors = CommentValidator.validate(c);
			if(errors.size() > 0) {
				entityManager.close();
				
				request.setAttribute("_token", request.getSession().getId());
				request.getSession().setAttribute("errors", errors);
				
				response.sendRedirect(request.getContextPath() + "/comments/new?topicId=" + t.getId() );
				
			} else {
				entityManager.getTransaction().begin();
				entityManager.persist(t);
				entityManager.persist(c);
				entityManager.getTransaction().commit();
				entityManager.close();
				
				response.sendRedirect(request.getContextPath() + "/topics/show?id=" + t.getId());
			}
						
		} else {
			System.err.println("Invalid _token");
		}
	}

}
