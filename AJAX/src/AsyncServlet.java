

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncServlet
 */
@WebServlet("/AsyncServlet")
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsyncServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=request.getParameter("userid");
		System.out.println(uid);
		
		try {
			
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success");
			
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
			System.out.println("Connection established");
			/*
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/vshare","root","root");*/
		
			String sql="select * from registerdb where userid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				out.print("<font color=red>NOT AVAILABLE FOR USE</font>");
			}
			else
			{
				out.print("<font color=green> AVAILABLE FOR USE</font>");
			}
	
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
