package org.student.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Get_Marks")

public class Get_Marks extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		String rollnumber = req.getParameter("rollnumber3");

		// jdbc
		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String query = "select * from practice.entermarks where rollnumber=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, rollnumber);
			// preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			String tel = resultSet.getString("telugu");
			String english = resultSet.getString("english");
			String maths = resultSet.getString("maths");
			String science = resultSet.getString("science");
			String social = resultSet.getString("social");
			String total = resultSet.getString("total");
			// String percentage = resultSet.getString("percentage");

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("jsprollnum", rollnumber);
			httpSession.setAttribute("jsptelugu", tel);
			httpSession.setAttribute("jspenglish", english);
			httpSession.setAttribute("jspmaths", maths);
			httpSession.setAttribute("jspscience", science);
			httpSession.setAttribute("jspsocial", social);
			httpSession.setAttribute("jsptotal", total);
			resp.sendRedirect("GetMark.jsp");

			/*
			 * printWriter.println("TELUGU " + tel); printWriter.println("ENGLISH: " +
			 * english); printWriter.println("MATHS: " + maths);
			 * printWriter.println("SCIENCE " + science); printWriter.println("SOCIAL " +
			 * social); printWriter.println("Total Marks " + total);
			 * //printWriter.println("% " + percentage);
			 */ System.out.println("excuted");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
