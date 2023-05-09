package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoCookie
 */
@WebServlet("/DemoCookie")
public class DemoCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private static final String SESSIONID_COOKIE = "sessionid";
	private static final String USERNAME_COOKIE = "usernamecookie";
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		

		System.out.println("cookie servlet is invoked");
		Cookie[] cookies =request.getCookies();
		
		boolean cookieFound = false;
	
		
		if(null != cookies)
		{
			for(Cookie cookie : cookies)
			{
			if(cookie.getName().equals(USERNAME_COOKIE))
			{
				cookieFound = true;
				response.getWriter().append("<html> <body> <h3> user   ::   "  +  request.getParameter("userName")  +   "...alredy logged in with cookie value ::"
				                                                   +   cookie.getValue()  +     "</h3></body></html>  ");
				break;
			}
			}
		}
		
		if(cookieFound == false)
		{
		Cookie uc = new Cookie(USERNAME_COOKIE ,request.getParameter("userName"));
		response.addCookie(uc);
		response.getWriter().append("added username cookie....");
			
			
			Cookie sessionCookie = new Cookie(SESSIONID_COOKIE ,LocalDateTime.now().toString());
			response.addCookie(sessionCookie);
			response.getWriter().append("session cookie added....");
		}
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
