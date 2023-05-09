package AssignmentProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName = request.getParameter("fullname");
		
		response.getWriter().append("<h1> Hello  <h1> "+ fullName);
		response.getWriter().append("<a href=\"OrderHistory.html\">ORDER</a>");
		
		response.getWriter().append("<br>");
		response.getWriter().append("<a href=\"shoppingcart.html\">PURCHASE</a>");
		//response.getWriter().append("<a href="">ORDER HISTORY</a>");
	///	HttpSession requestSession = request.getSession(true);
		
		// String val1=(String)requestSession.getAttribute(S_ATTRIBUTE);
		// response.getWriter().append("fullname ::" +fullName).append("USERID  ::  " + userid).append ("SESSION_ATTRIBUTE :: " +val1);
		
		//request.getRequestDispatcher("shoppingcart.html").include(request, response);;
			
		
		
		
		
	}

}
