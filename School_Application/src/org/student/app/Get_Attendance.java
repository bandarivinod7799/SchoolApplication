package org.student.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

@WebServlet("/Get_Attendance")

public class Get_Attendance extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
		 * resp) throws ServletException, IOException { // TODO Auto-generated method
		 * stub super.doPost(req, resp);
		 */ resp.setContentType("text/html");
		ResultSet resultSet = null;

		String rollnumber3 = req.getParameter("rollnumber2"); // Retrieve vlaue from HTML
		PrintWriter printWriter = resp.getWriter(); // Print output on browser

		// JDBC CODE
		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String dbpath = "select * from practice.studentattendance where rollnumber=?";
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Driver class
			Connection connection = (Connection) DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(dbpath);
			preparedStatement.setString(1, rollnumber3);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String month = resultSet.getString("month"); // ("month");
			String week = resultSet.getString("week");
			String day = resultSet.getString("day");
			printWriter.println("<html>");
			printWriter.println("<h1 align='center' style='color:#FF66CC;background: rgba(0, 0, 0, 0.3);'> RollNumber :" + rollnumber3+"</h1>");
			printWriter.println("<body bgcolor='lightblue'>");
			printWriter.println("<table align='center' bordercolor='fuchsia' border='1px'>");
			printWriter.println("<h2><tr><td>MONTH</td><td>"+month+"<td></tr></h2>");
			printWriter.println("<h3><tr><td>WEEK</td><td>"+week+"<td></tr></h3>");
			printWriter.println("<h3><tr><td style='color:green'>DAY</td><td>"+day+"<td></tr>");
			printWriter.println("</body>");
			printWriter.println("</html>");
			printWriter.println("");
			printWriter.println();
			printWriter.println();
			printWriter.println();
			printWriter.println();

			/*
			 * HttpSession httpSession = req.getSession();
			 * httpSession.setAttribute("jspmonth", month);
			 * httpSession.setAttribute("jspweek", week);
			 * httpSession.setAttribute("jspday",day);
			 * resp.sendRedirect("getAttendance.jsp");
			 * System.out.println("Excuted attendance java file");
			 */
			System.out.println("Attendance class");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * finally {
		 * 
		 * String month = resultSet.getString("month"); //("month"); String week =
		 * resultSet.getString("week"); String day = resultSet.getString("day");
		 * HttpSession httpSession = req.getSession();
		 * httpSession.setAttribute("jspmonth", month);
		 * httpSession.setAttribute("jspweek", week);
		 * httpSession.setAttribute("jspday",day);
		 * 
		 * resp.sendRedirect("getAttendance.jsp"); }
		 */
	}
}
