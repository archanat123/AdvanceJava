package AssignmentProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginFormValidation")
public class LoginFormValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String S_ATTRIBUTE ="sessionAttribute";
	
       
    
    public LoginFormValidation() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName = request.getParameter("fullname");
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		if(fullName.isEmpty()||userid.length()<10)
		{
		request.getRequestDispatcher("Error.html").forward(request, response);
		
		}else
		{
			HttpSession requestSession = request.getSession(true);
			
			 String val1=(String)requestSession.getAttribute(S_ATTRIBUTE);
			// response.getWriter().append("fullname ::" +fullName).append("USERID  ::  " + userid).append ("SESSION_ATTRIBUTE :: " +val1);
			 request.getRequestDispatcher("/HomeServlet").forward(request, response);
			
		//	request.getRequestDispatcher("shoppingcart.html").include(request, response);
		}
		
		
	//	doGet(request, response);
	}

}
