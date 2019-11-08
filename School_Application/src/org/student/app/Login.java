package org.student.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")

public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollnumber = request.getParameter("rollnumber");
		String password = request.getParameter("password");
		PrintWriter printWriter = response.getWriter();

		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String query = "select * from practice.studentreg where rollnumber=? and password=? ";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("llllll");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, rollnumber);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				String name = resultSet.getString("name");
				String urclass = resultSet.getString("urclass");
				String phnumber = resultSet.getString("phnumber");
				String mailId = resultSet.getString("mailid");
				String rollnumber1 = resultSet.getString("rollnumber");

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("jspname", name);
				httpSession.setAttribute("jspurclass", urclass);
				httpSession.setAttribute("jspphnumber", phnumber);
				httpSession.setAttribute("jspmailID", mailId);
				httpSession.setAttribute("jsprollnumber1", rollnumber1);
				// httpSession.setAttribute("", );
				response.sendRedirect("login.jsp?jsprollnumber1=" + rollnumber1);

				/*
				 * printWriter.println("welcome "+name); printWriter.println("Class :"+urclass);
				 * printWriter.println("PhoneNumber :"+phnumber);
				 * printWriter.println("MailID :"+mailId);
				 */ System.out.println(name);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login_validation.html");
				dispatcher.include(request, response);
				System.out.println("enter correctpassword");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
