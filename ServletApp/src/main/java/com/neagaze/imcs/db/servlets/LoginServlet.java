package com.neagaze.imcs.db.servlets;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginServlet.class);

    /**
     * Default constructor. 
     */
    public LoginServlet() {
    	logger.debug("LoginServlet: constructor called");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		logger.debug("LoginServlet:init method called");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		logger.debug("LoginServlet: destroy called");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get data from request
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//process and generate response
		if("imcs".equals(userId) && "tiger".equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", "imcs");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("message", "Invalid User!! Try again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
			dispatcher.forward(request, response);
		}
		//send the response.
	}

}
