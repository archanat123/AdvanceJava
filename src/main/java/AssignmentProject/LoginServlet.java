package AssignmentProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String S_ATTRIBUTE ="sessionAttribute";
	//private static final String REQUEST_ATTRIBUTE ="requestParameter";
       
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullname");
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		
		HttpSession requestSession = request.getSession(true);
		 //String sessionId = requestSession.getId();
	 requestSession.setAttribute(S_ATTRIBUTE,userid);
 //    String val1=(String)requestSession.getAttribute(S_ATTRIBUTE);
//	 response.getWriter().append("fullname ::" +fullName).append("USERID  ::  " + userid).append ("SESSION_ATTRIBUTE :: " +val1);
	RequestDispatcher rd =request.getRequestDispatcher("/LoginFormValidation");
		
		rd.forward(request, response);
	//	rd.include(request, response);
		
	//response.getWriter().print("<h1> my details from post </h1>");
	
		
	//	doGet(request, response);
	}

}
