package org.baali.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ResultSetInsertRow
{

	public static void main(String[] args) throws SQLException, ParseException
	{
		String url = "jdbc:mysql://localhost/employees";
		String userName = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		String query = "select * from employees  order by emp_no desc limit 3";
		ResultSet resultSet = statement.executeQuery(query);
		int rowCount = 0;
		resultSet.last();
		rowCount = resultSet.getRow();
		System.out.printf("Number of rows before insert:\t%s\n", rowCount);
		System.out.printf("%85s %n", "---------------------------------------------------------------------------------");

		int columnCount = resultSet.getMetaData().getColumnCount();
		for (int i = 1; i <= columnCount; i++) 
		{
			System.out.printf("%12s%2s|%2s", resultSet.getMetaData().getColumnName(i), "", "");
		}
		System.out.printf("\n%85s\n", "---------------------------------------------------------------------------------");
		// move to its original position
		resultSet.beforeFirst();
		while (resultSet.next())
		{
			for(int i = 1; i <= columnCount; i++)
			{
				System.out.printf("%12s%2s|%2s", resultSet.getObject(i), "", "" );
			}
			System.out.println();		
		}
		String birthDate = "2016-10-26";
		String joiningDate = "2030-10-30";
		Date sqlBirthDate = new Date(new SimpleDateFormat("yyyy-mm-dd").parse(birthDate).getTime());
		Date sqlHireDate = new Date(new SimpleDateFormat("yyyy-mm-dd").parse(joiningDate).getTime());
		
		resultSet.beforeFirst();
		resultSet.moveToInsertRow();
		
		resultSet.updateInt(1, 500001);
		resultSet.updateDate(2, sqlBirthDate);
		resultSet.updateString(3, "Sindhu");
		resultSet.updateString(4, "Balaji");
		resultSet.updateString(5, "F");
		resultSet.updateDate(6, sqlHireDate);
		resultSet.insertRow();
		
		String divider = "=================================";
		System.out.printf("%s\n\t After Update:\n%s\n", divider, divider);
		
		System.out.println();
		System.out.printf("Number of rows AFter insert:\t%s\n", rowCount);
		System.out.printf("%85s %n", "---------------------------------------------------------------------------------");

		for (int i = 1; i <= columnCount; i++)
		{
			System.out.printf("%12s%2s|%2s", resultSet.getMetaData().getColumnName(i), "", "");
		}
		System.out.printf("\n%85s\n", "---------------------------------------------------------------------------------");
		// move to its original position
		resultSet.beforeFirst();
		while (resultSet.next())
		{
			for(int i = 1; i <= columnCount; i++)
			{
				System.out.printf("%12s%2s|%2s", resultSet.getObject(i), "", "" );
			}
			System.out.println();		
		}
		
	}

}
