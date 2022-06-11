package controllers.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.JPAUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("_token", request.getSession().getId());
		request.setAttribute("IsError", false);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean res = false;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User u = null;

        if(username != null && !username.equals("") && password != null && !password.equals("")) {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

            try {
                u = entityManager.createQuery("SELECT u FROM User u where u.name = :username AND u.password = :password", User.class)
                      .setParameter("username", username)
                      .setParameter("password", password)
                      .getSingleResult();
            } catch(NoResultException ex) {}

            entityManager.close();

            if(u != null) {
            	res = true;
            }
        }

        if(!res) {
            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("IsError", true);
            request.setAttribute("userName", username);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
            rd.forward(request, response);
        } else {
            request.getSession().setAttribute("user", u);
            response.sendRedirect(request.getContextPath() + "/topics/index");
        }
	}

}
