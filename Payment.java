package org.project.book;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.sql.*;

public class Payment extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Connection con=null;
		Statement stm=null;
		System.out.println("Hello");
		String conUrl = "jdbc:mysql://localhost:3306/";
		String driverName = "com.mysql.jdbc.Driver";
		String databaseName = "raghu";
		String usrName = "root";
		String usrPass = "dinga";
		System.out.println("Hello");
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
			stm = con.createStatement();
			System.out.println("Hello");
			String cardNO =(req.getParameter("cardno")).toString();
			String expiry =(req.getParameter("expdate")).toString();
			String cvvNo =(req.getParameter("cvv")).toString();
			int cvv=Integer.parseInt(cvvNo);
			System.out.println("Hello");
			String str="insert into `raghu`.`paymentdetails`(cardNo, expiryDate, CVV) values("+cardNO+", "+expiry+", "+cvv+");";
			stm.execute(str);
			
			resp.sendRedirect("Acknowledgment.html");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}



