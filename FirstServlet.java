package org.project.book;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

//import com.mysql.jdbc.Connection;
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	Connection connect = null;
	Statement stm = null;
	System.out.println("Hello");
	String conUrl = "jdbc:mysql://localhost:3306/";
	String driverName = "com.mysql.jdbc.Driver";
	String databaseName = "raghu";
	String usrName = "root";
	String usrPass = "dinga";
	
	
	System.out.println("Hello");
	try 
	{
		String uname=req.getParameter("un");
		System.out.println("Hello");
		String fname=req.getParameter("fn");
		String lname=req.getParameter("ln");
		String DoB=req.getParameter("Dob");
		String Email=req.getParameter("email");
		String Mobile=req.getParameter("mob_no");
		String Gender=req.getParameter("gender");
		String City=req.getParameter("cy");
		String Pincode=req.getParameter("pc");
		int pin=Integer.parseInt(Pincode);
		String State=req.getParameter("st");
		String Country=req.getParameter("cty");
		String password=req.getParameter("password");
		try {
			// Loading Driver
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		System.out.println("Driver is loaded and registered");
		connect = DriverManager.getConnection((conUrl + databaseName), usrName,
				usrPass);
		
		System.out.println("Connection Established");
		stm = connect.createStatement();
		String qry="insert into `raghu`.`register` (username, firstName, lastName, DOB, email, phone, gender, city, pincode, state, country, passwd) values("+uname+", "+fname+", "+lname+", "+DoB+", "+Email+", "+Mobile+", "+Gender+", "+City+", "+pin+", "+State+", "+Country+", "+password+")";
		
		stm.execute(qry);
		/*pstmt=con.prepareStatement(qry);
		System.out.println("Created platform for executing");
		pstmt.setString(1, uname);
		pstmt.setString(2, fname);
		pstmt.setString(3, lname);
		pstmt.setString(4, DoB);
		pstmt.setString(5, Email);
		pstmt.setString(6,Mobile);
		pstmt.setString(7, Gender);
		pstmt.setString(8, City);
		pstmt.setInt(9, pin);
		pstmt.setString(10, State);
		pstmt.setString(11, Country);
		pstmt.setString(12,uname);
		pstmt.setString(13, password);
		pstmt.executeUpdate();
		System.out.println("Datas are inserted into DataBase");*/
		resp.sendRedirect("Acknowledgment.html");
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
}
}
