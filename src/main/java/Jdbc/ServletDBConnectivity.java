package Jdbc;

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

/**
 * Servlet implementation class ServletDBConnectivity
 */
@WebServlet("/ServletDBConnectivity")
public class ServletDBConnectivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
	
   
    public ServletDBConnectivity() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Statement st = con.createStatement();
		
		ResultSet result = st.executeQuery("SELECT * FROM user");
		while(result.next()) {
			Integer id =result.getInt(1);
			String userid =result.getString(2);
			String password =result.getString(3);
			String displyName = result.getString(4);
			
			System.out.println("ID::" + id +  
					"USERID  ::  " + userid + 
					"PASSWORD  :: " + password +
					"NAME  :: "  +displyName);
			response.getWriter().append("id ::" +id).append("USERID  ::  " + userid).append ("PASSWORD  :: " + password).append("NAME  :: "  +displyName);
		}
		result.close();
		st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
