package org.admin.app;

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

@WebServlet("/Enter_Marks")
public class Enter_Marks extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rollnumber = req.getParameter("rollnumber");

		String t = req.getParameter("telugu");
		int telugu = Integer.parseInt(t);

		String e1 = req.getParameter("english");
		int english = Integer.parseInt(e1);

		String m = req.getParameter("maths");
		int maths = Integer.parseInt(m);

		String s = req.getParameter("science");
		int science = Integer.parseInt(s);

		String s1 = req.getParameter("social");
		int social = Integer.parseInt(s1);

		PrintWriter printWriter = resp.getWriter();
		int total = telugu + english + maths + science + social;
		double average = Double.parseDouble(t + e1 + m + s1 + s);
		double percentage = (average % 500) * 100;

		printWriter.println(telugu + english + maths + science + social);

		// jdbc code

		String url = "jdbc:mysql://localhost:3306?user=root&password=77996";
		String query = "insert into practice.entermarks values(?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, rollnumber);
			preparedStatement.setInt(2, telugu);
			preparedStatement.setInt(3, english);
			preparedStatement.setInt(4, maths);
			preparedStatement.setInt(5, science);
			preparedStatement.setInt(6, social);
			preparedStatement.setInt(7, total);
			preparedStatement.setDouble(8, percentage);

			printWriter.println(average);
			preparedStatement.executeUpdate();
			System.out.println("ffffffffffff");
			System.err.println(percentage);
			printWriter.println("Successfully Registered");
			connection.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
