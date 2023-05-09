package AssignmentProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String S_ATTRIBUTE ="sessionAttribute";
	private Connection con;
       
    
    public OrderServlet() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("setting up the connection");
		String dbURL ="jdbc:mysql://localhost:3306/";
		String dbName = "apex";
		String dbUsername = "root";
		String dbPassword = "root";
		StringBuffer sb =new StringBuffer(dbURL);
		
		try {
		String dbDriver ="com.mysql.cj.jdbc.Driver";
		Class.forName(dbDriver);
		con = DriverManager.getConnection(sb.append(dbName).toString(),dbUsername,dbPassword);
		
		}catch (ClassNotFoundException e1 )
		{ 
			
			e1.printStackTrace();
		}catch (SQLException e)
		{
			
			e.printStackTrace(); }

	}

	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		HttpSession requestSession = request.getSession(true);
		
		 String userid=(String)requestSession.getAttribute(S_ATTRIBUTE);
		// String ProductName = request.getParameter("ProductName");
		String product_name = "Shirt";
		
		String quantity = request.getParameter("quantity");
		//String PRICE = request.getParameter("price");
		String price = "45";
		
		try {
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO apex.orderhistory (userid,product_name,quantity,price) VALUES (?,?,?,?)");
			ps.setString(1,userid);
			ps.setString(2,product_name);
			ps.setString(3,quantity);
			ps.setString(4,price);
			
			response.getWriter().append("PN ::" +product_name).append("QUANTITY  ::  " + quantity).append ("PRICE  :: " + price);
			int numberofRecords =ps.executeUpdate();
			System.out.println("number of record inserted is"+ numberofRecords);
			ps.close();
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e)
		{
			
			e.printStackTrace();

		}
		
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
