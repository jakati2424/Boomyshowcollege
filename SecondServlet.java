package org.project.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

public class SecondServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		java.sql.Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query="select username from raghu.register where email='apoorva.jakati@gmail.com',password='apoorva'";
		PrintWriter out=resp.getWriter();
		out.print("<html><body bgcolor='yellow'><h1>Datas are fetcched Database</h1>"
				+ "<button><a href='BookMyShow.html'>Back</a></button></body></html>");
		out.flush();
		out.close();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=apoorva");
			System.out.println("Connection Established");
			pstmt=con.prepareStatement(query);
			//pstmt.setString(1, email);
			//pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			System.out.println("Created platform for executing");
			if (rs.next()) 
			{
				String username=rs.getString(1);
				System.out.println(username);
			}
			System.out.println("Datas are fetched from database");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
