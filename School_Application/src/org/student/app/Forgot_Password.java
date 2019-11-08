package org.student.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forgot_Password.java")
public class Forgot_Password extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rollNumber = req.getParameter("rollNumber");
		String newPassword = req.getParameter("newpassword");
		String confirmNewPassword = req.getParameter("newconfirmpassword");
		PrintWriter printWriter = resp.getWriter();

		// jdbc code

		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String query = "update  practice.studentreg set password=? where rollnumber=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, rollNumber);

			// preparedStatement.setString(3, confirmNewPassword);
			preparedStatement.executeUpdate();
			if (newPassword.equals(confirmNewPassword)) {

				preparedStatement.executeUpdate();
				printWriter.println("succesfully changed");
				System.out.println(newPassword);
				preparedStatement.setString(1, newPassword);

			} else {
				System.out.println("no");
				printWriter.println("Password doesnot matched");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
