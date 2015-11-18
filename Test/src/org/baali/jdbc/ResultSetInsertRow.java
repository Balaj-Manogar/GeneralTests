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
		int rowCount = getRowCount(resultSet);
		System.out.printf("Number of rows before insert:\t%s\n", rowCount);
		String lineBreak = "----------------------------------------------------------------------------------------------------";
		System.out.printf("%95s %n", lineBreak);

		printColumnNames(resultSet);
		
		System.out.printf("\n%95s\n", lineBreak);
		// move to its original position
		resultSet.beforeFirst();
		printData(resultSet);
		
		String birthDate = "2016-10-26";
		String joiningDate = "2030-10-30";
		Date sqlBirthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate).getTime());
		Date sqlHireDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate).getTime());
		// this is update part other codes are just used to print
		resultSet.beforeFirst();
		resultSet.moveToInsertRow();
		
		resultSet.updateInt(1, 500001);
		resultSet.updateDate(2, sqlBirthDate);
		resultSet.updateString(3, "Siu");
		resultSet.updateString(4, "Balaji");
		resultSet.updateString(5, "F");
		resultSet.updateDate(6, sqlHireDate);
		resultSet.insertRow();
		
		String divider = "=================================";
		System.out.printf("%s\n\t After Update:\n%s\n", divider, divider);
		
		
		rowCount = getRowCount(resultSet);;
		System.out.printf("Number of rows AFter insert:\t%s\n", rowCount);
		System.out.printf("%95s %n", lineBreak);

		printColumnNames(resultSet);
		
		System.out.printf("\n%95s\n", lineBreak);
		// move to its original position
		resultSet.beforeFirst();
		printData(resultSet);
		
	}

	private static int getRowCount(ResultSet resultSet) throws SQLException
	{
		int rowCount = 0;
		resultSet.last();
		rowCount = resultSet.getRow();
		return rowCount;
	}

	private static void printData(ResultSet resultSet) throws SQLException
	{
		while (resultSet.next())
		{
			for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
			{
				System.out.printf("%12s%2s|%2s", resultSet.getObject(i), "", "" );
			}
			System.out.println();		
		}
	}

	private static void printColumnNames(ResultSet resultSet) throws SQLException
	{
		int columnCount = resultSet.getMetaData().getColumnCount();
		for (int i = 1; i <= columnCount; i++) 
		{
			System.out.printf("%12s%2s|%2s", resultSet.getMetaData().getColumnName(i), "", "");
		}
		
	}

}
