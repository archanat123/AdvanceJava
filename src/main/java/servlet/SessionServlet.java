package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SESSION_ATTRIBUTE ="sessionAttribute";
	private static final String REQUEST_ATTRIBUTE ="requestParameter";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession requestSession = request.getSession(true);
		//String userId = (String) requestSession.getAttribute("userId");
		
		//requestSession.setAttribute(SESSION_ATTRIBUTE, LocalDateTime.now().toString());
		
		String val1=(String)requestSession.getAttribute(SESSION_ATTRIBUTE);
		
		String sessionId = requestSession.getId();
		response.getWriter().write(String.format("<html><h2>"+  "session id: %s%n. Session Attribute ::%s" +  "</h2></html>",sessionId,val1));
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession requestSession = request.getSession(true);
		String sessionId = requestSession.getId();
	 requestSession.setAttribute(SESSION_ATTRIBUTE,"abc@gmail.com");
	 String val1=(String)requestSession.getAttribute(SESSION_ATTRIBUTE);
	 response.getWriter().write(String.format("<html><h2>"+"session id: %s%n. Session Attribute ::%s" +"</h2></html>",sessionId,val1));
		
		
		
		
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

}
