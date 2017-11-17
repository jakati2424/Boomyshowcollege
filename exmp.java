package org.project.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


public class exmp extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jdbc connection
		Connection con = null; // connection reference variable for getting connection
		
		Statement stmt = null; // Statement reference variable for query execution
		
		String conUrl = "jdbc:mysql://localhost:3306/";
		String driverName = "com.mysql.jdbc.Driver";
		String databaseName = "netflix&chill";
		String usrName = "root";
		String usrPass = "navya@123";

		try {
			// Loading Driver
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		try {
			// Getting Connection
			con = DriverManager.getConnection((conUrl + databaseName), usrName,
					usrPass);
			// Creating Statement for query execution
			stmt = con.createStatement();
			
		
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		
		String fname =(request.getParameter("FirstName")).toString();
		String lname=(request.getParameter("LastName")).toString();
		String uname=(request.getParameter("Username")).toString();
		String pswd=(request.getParameter("Password")).toString();
		String email=(request.getParameter("Email")).toString();
		//String temp=(request.getParameter("CardNo")).toString();
		//int cardNo=Integer.parseInt(temp);
		
		 
		 //System.out.println(fname+" "+lname+" "+uname+" "+pswd+" "+email);
		 
		 String s="insert into `netflix&chill`.`users` (`UserName`,`Password`,`First_Name`,`Last_Name`,`emailID`) values ('"+uname+"','"+pswd+"','"+fname+"','"+lname+"','"+email+"');";
		
		 stmt.execute(s);
		    response.sendRedirect("index.html");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
