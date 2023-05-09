package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserFormServlet
 */
@WebServlet("/UserFormServlet")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullname");
		String phno = request.getParameter("Phonenumber");
		String gender = request.getParameter("gender");
	//	RequestDispatcher rd =request.getRequestDispatcher("/ServletFormValidation");
		//rd.forward(request, response);
	//	rd.include(request, response);
		
	response.getWriter().print("<h1> my details from get </h1>");
	
		
response.getWriter().print("<h1> <br> </h1>"+fullName +"==="+gender+"===="+phno);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String fullName = request.getParameter("fullname");
		String phno = request.getParameter("Phonenumber");
		String gender = request.getParameter("gender");
		
		response.getWriter().print("<h1> my details from post </h1>");
		response.getWriter().print("<h1> <br> </h1>"+fullName +"==="+gender+"===="+phno);
		
	}

}
