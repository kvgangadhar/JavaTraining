package com.neagaze.imcs.db.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by neaGaze on 11/12/17.
 */
public class HomePageServlet extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String obj = (String) session.getAttribute("user");
        RequestDispatcher dispatcher;
        if(obj == "imcs") {
           //Customer customer = new Customer();
           //customer.setName("Tom Rachmaninoff");

           dispatcher = request.getRequestDispatcher("/pages/homepage.jsp");
           dispatcher.forward(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            request.setAttribute("message", "object sent is incorrect");
            dispatcher.forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
