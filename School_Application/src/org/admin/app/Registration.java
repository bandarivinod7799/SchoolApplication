package org.admin.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String fname = req.getParameter("fathername");
		String phoneNumber = req.getParameter("phonenumber");
		String mailID = req.getParameter("mailid");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dateofbirth");
		String hno = req.getParameter("hnumber");
		String village = req.getParameter("village");
		String mandal = req.getParameter("mandal");
		String urClass = req.getParameter("class");
		String rollnumber = req.getParameter("rollnumber");
		String medium = req.getParameter("medium");
		String password = req.getParameter("password");

		PrintWriter printWriter = resp.getWriter();

		printWriter.println(gender);
		printWriter.println();
		printWriter.println(password);
		printWriter.println();
		printWriter.println();
		printWriter.println();
		printWriter.println();

		// jdbc code

		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String query = "insert into practice.studentreg values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, fname);
			preparedStatement.setString(3, phoneNumber);
			preparedStatement.setString(4, mailID);
			preparedStatement.setString(5, gender);
			preparedStatement.setString(6, dob);
			preparedStatement.setString(7, hno);
			preparedStatement.setString(8, village);
			preparedStatement.setString(9, mandal);
			preparedStatement.setString(10, urClass);
			preparedStatement.setString(11, rollnumber);
			preparedStatement.setString(12, medium);
			preparedStatement.setString(13, password);
			preparedStatement.executeUpdate();

		
			printWriter.println("Successfully Registered");
			connection.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
