package org.project.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayMentServlet extends HttpServlet
{
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	   {
	 	  PrintWriter out=resp.getWriter();
	 	 out.print("<html><style type='text/css'>h1{text-align: center;}.button{background-color: #4CAF50;padding: 15px;text-align: center;font-size: 20px;border: none;color: white;display: inline-block;}</style><body bgcolor='blue'><h1>PayMent Successfull</h1>"
					+ "<button class='button'><a href='BookMyShow.html'>Go Back To Home</a></button></body></html>");
			out.flush();
			out.close();
	   }
}
