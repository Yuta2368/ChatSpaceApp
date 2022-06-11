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

import models.Topic;
import utils.JPAUtil;

@WebServlet("/topics/index")
public class TopicsIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Topic> topics = entityManager.createQuery("SELECT t FROM Topic t ORDER BY t.createdAt DESC", Topic.class).getResultList();  
		
		entityManager.close();
		
		request.setAttribute("topics", topics);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topics/index.jsp");
        rd.forward(request, response);
	}

}
