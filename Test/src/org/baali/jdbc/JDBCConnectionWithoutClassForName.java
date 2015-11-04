package org.baali.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCConnectionWithoutClassForName
{

	public static void main(String[] args) throws SQLException
	{
		// simple connection 
		String url = "jdbc:mysql://localhost/employees";
		String userName = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		String query = "select * from employees limit 10";
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next())
		{
			System.out.print(resultSet.getString(1) + ", ");
			System.out.print(resultSet.getString(2) + ", ");
			System.out.print(resultSet.getString(3));
			System.out.println();
		}
	}

}
