package org.baali.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ResultSetDeleteRow
{

	public static void main(String[] args) throws SQLException, ParseException
	{
		String url = "jdbc:mysql://localhost/employees";
		String userName = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		
		String query = "select * from employees  order by emp_no desc limit 3";
		ResultSet resultSet = statement.executeQuery(query);
		
		// print initial fetched data
		printLine();		
		System.out.println("INITIAL_FETCH");		
		printAll(resultSet);
		
		//inserting data
		insertRow(resultSet);		
		
		//print after insert 
		resultSet.beforeFirst();
		printLine();
		System.out.println("AFTER_INSERT");
		printAll(resultSet);		
		
		//move to last row and delete inserted row
		resultSet.last();
		resultSet.deleteRow();
		
		// print after deleted
		resultSet.beforeFirst();
		printLine();
		System.out.println("AFTER_DELETE");
		printAll(resultSet);
		
		
	}

	private static void insertRow(ResultSet resultSet) throws ParseException, SQLException
	{
		String birthDate = "1978-10-26";
		String joiningDate = "2000-10-30";
		Date sqlBirthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate).getTime());
		Date sqlHireDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate).getTime());
		// this is update part other codes are just used to print
		resultSet.beforeFirst();
		resultSet.moveToInsertRow();
		
		resultSet.updateInt(1, 500002);
		resultSet.updateDate(2, sqlBirthDate);
		resultSet.updateString(3, "abc");
		resultSet.updateString(4, "xyz");
		resultSet.updateString(5, "F");
		resultSet.updateDate(6, sqlHireDate);
		resultSet.insertRow();
	}

	private static void printAll(ResultSet resultSet) throws SQLException
	{
		int columnCount = resultSet.getMetaData().getColumnCount();
		
		printColumnNames(resultSet, columnCount);		
		printData(resultSet);
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

	private static void printColumnNames(ResultSet resultSet, int columnCount) throws SQLException
	{
		printLine();
		for (int i = 1; i <= columnCount; i++) 
		{
			System.out.printf("%12s%2s|%2s", resultSet.getMetaData().getColumnName(i), "", "");
		}
		printLine();
		System.out.println();
	}

	private static void printLine()
	{
		String lineBreak = "----------------------------------------------------------------------------------------------------";
		System.out.printf("\n%95s\n", lineBreak);
	}

	

}
