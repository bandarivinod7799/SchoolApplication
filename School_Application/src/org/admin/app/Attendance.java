package org.admin.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/Attendance")
public class Attendance extends GenericServlet

{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
		 * resp) throws ServletException, IOException { // TODO Auto-generated method
		 * stub super.doPost(req, resp);
		 */
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		String rollnumber = req.getParameter("rollnumber");
		String month = req.getParameter("month");
		String week = req.getParameter("week");
		String[] day = req.getParameterValues("attendance");
		printWriter.println(rollnumber);

		String selectDay = "";

		System.out.println("month " + month);

		printWriter.println("<h1>month</h1>" + month);

		System.out.println("week " + week);
		printWriter.println("<h1 color='red'>week</h1><br>" + week);
		printWriter.println("<h1>Day</h1>");

		for (int k = 0; k < day.length; k++) {
			selectDay = selectDay + day[k];
			System.out.println("Day " + selectDay);
			printWriter.println(selectDay);
		}

		// JDBC CODE
		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String query = "insert into practice.studentattendance values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, rollnumber);
			preparedStatement.setString(2, month);
			preparedStatement.setString(3, week);
			preparedStatement.setString(4, selectDay);

	 		preparedStatement.executeUpdate();

			System.out.println("Successfully Registered");
			printWriter.println("<h1>Successfully Registered</h1>");
			connection.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==================================================");

	}

}
