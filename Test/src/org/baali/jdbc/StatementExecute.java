package org.baali.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExecute
{

	public static void main(String[] args) throws SQLException
	{
		String url = "jdbc:mysql://localhost/employees";
		String userName = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		
		String query = "select * from employees limit 10";
		boolean select = statement.execute(query);
		// if process true then returns ResultSet Object for select statements
		// if process false then it has int value which indicates the affected row(s) count
		if(select)
		{
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next())
			{
				System.out.print(resultSet.getString(1) + ", ");
				System.out.print(resultSet.getString(2) + ", ");
				System.out.print(resultSet.getString(3));
				System.out.println();
			}
		}
		
		// Count is also a result set
		query = "select count(*) from employees";
		select = statement.execute(query);
		if(select)
		{
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next())
			{
				System.out.print("Count: " + resultSet.getString(1));
			}
		}
		
	}

}
