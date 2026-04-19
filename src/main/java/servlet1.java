import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet1() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 out.println("<h2>Student List</h2>");
		 String url="jdbc:oracle:thin:@//127.0.0.1:1521/xepdb1";
			String user="system";
			String password="system123";
		 try
		 {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection(url,user,password);
		  Statement stmt=con.createStatement();
		  ResultSet res=stmt.executeQuery("select * from studentdb");
		  out.println("<table border='1'>");
		  out.println("<tr><th>Name:</th><th>Email:</th></tr>");
		  while(res.next())
		  {
			  out.println("<tr>");
			  out.println("<td>"+res.getString("name")+"<td>"+res.getString("email"));
			  out.println("<tr>");
		  }
		  out.println("</table>");
		  con.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  out.println(e);
			  out.println("Database Error");
			  
		  }
			 
		 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
