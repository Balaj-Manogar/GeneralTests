package org.baali.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetColumnNameAndCount
{

	public static void main(String[] args) throws SQLException
	{
		String url = "jdbc:mysql://localhost/employees";
		String userName = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();

		String query = "select * from employees limit 10";
		ResultSet resultSet = statement.executeQuery(query);
		int columnCount = resultSet.getMetaData().getColumnCount();
		System.out.println("Column count: " + columnCount);
		// --%85 describes minimum width
		System.out.printf("%85s %n","---------------------------------------------------------------------------------");
		
		for(int i = 1; i < columnCount; i++)
		{
			System.out.printf("%12s%2s|%2s", resultSet.getMetaData().getColumnName(i),  "", "" );
		}
		System.out.println();
		System.out.printf("%85s ","---------------------------------------------------------------------------------");
		System.out.println();
			while (resultSet.next())
			{
				for(int i = 1; i < columnCount; i++)
				{
					System.out.printf("%12s%2s|%2s", resultSet.getObject(i), "", "" );
				}
				System.out.println();
				
				
			}
		

		
	}

}
