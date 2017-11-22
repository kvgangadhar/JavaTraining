package trng.imcs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get data
		String productName = request.getParameter("productName");
		
		//process
		if (request.getSession().getAttribute("products") == null) 
			request.getSession().setAttribute("products", new ArrayList());
		
		((ArrayList)request.getSession().getAttribute("products")).add(productName);
		
		//generate response
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/products.jsp");
		dispatcher.forward(request, response);
	}

}
