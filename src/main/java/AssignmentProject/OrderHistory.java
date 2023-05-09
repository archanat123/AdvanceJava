package AssignmentProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String S_ATTRIBUTE ="sessionAttribute";
	private Connection con;
    
    public OrderHistory() {
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
			
			e.printStackTrace();

		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Statement st = con.createStatement();
			HttpSession requestSession = request.getSession(true);
			String userid1=(String)requestSession.getAttribute(S_ATTRIBUTE);
			response.getWriter().append("hello  " + userid1);
		
	      	ResultSet result = st.executeQuery("SELECT * FROM apex.orderhistory WHERE userid='  archana123'");
	    
		while(result.next()) {
			String userid =result.getString(1);
			String product_name =result.getString(2);
			String quantity = result.getString(3);
			Integer price =result.getInt(4);
			
			System.out.println( 
					"USERID  ::  " + userid + 
					"PRODUCT_NAME  :: " + product_name +
					"QUANTITY  :: "  + quantity +
					"PRICE   :: "  + price);
			response.getWriter().append("USERID  ::  " + userid).append("PRODUCT_NAME  :: " + product_name).append("QUANTITY  :: "  + quantity).append("PRICE   :: "  + price);
			response.getWriter().append("<br>");
		}
		result.close();
		st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
