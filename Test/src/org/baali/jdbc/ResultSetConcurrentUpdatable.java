package org.baali.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ResultSetConcurrentUpdatable
{

	public static void main(String[] args) throws SQLException, ParseException
	{
		String url = "jdbc:mysql://localhost/employees";
		String userName = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// ### Primary key is important otherwise com.mysql.jdbc.NotUpdatable error throws
		String query = "select emp_no, first_name, hire_date from employees where first_name='Balaji'";
		String date = "2020-12-26";
		Date futureHireDate = new Date(new SimpleDateFormat("yyyy-mm-dd").parse(date).getTime());
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();// move to first row
		
		System.out.println("Name\t Joining Date");
		System.out.println("------------------------");
		System.out.println(resultSet.getString(2) + "\t " + resultSet.getDate(3));
		
		//update resultset
		resultSet.updateDate(3, futureHireDate);
		resultSet.updateRow();
		
		// move to first row
		resultSet.absolute(1);
		
		System.out.println("\n\n#########--UPDATED--#########");
		System.out.println("Name\t Joining Date");
		System.out.println("------------------------");
		System.out.println(resultSet.getString(2) + "\t " + resultSet.getDate(3));
		

	}

}
