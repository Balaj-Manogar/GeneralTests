package org.baali.demos.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseMetaDataDemo
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		int i = 1;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employees?"
				+ "user=root&password=root");
		
		DatabaseMetaData dbmd = connection.getMetaData();
		
		System.out.println("Database name: " + dbmd.getDatabaseProductName());
		
		System.out.println("DB_Major Version: " + dbmd.getDatabaseMajorVersion());
		System.out.println("DB_Minor Version: " + dbmd.getDatabaseMinorVersion());
		
		ResultSet rs = dbmd.getTables(null, null, null, null);
		
		
		
		// Getting ResultSet MetaData
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		System.out.println("Column Count: " + columnCount);
		System.out.println("Printing Result set meta Deta");
		for(int j = 1; j < columnCount + 1; j++)
		{
			System.out.println(rsmd.getColumnLabel(j));
		}
		//Get Table names
		System.out.println("Tables");
		System.out.println("---------------");
		while(rs.next())
		{
			System.out.println(rs.getString(3));
			i++;
		}
		
		// Get Column names
		rs = dbmd.getColumns(null, null, "employees", null);
		
		while(rs.next())
		{
			System.out.println("Name: \t" + rs.getString(4) + " Type: \t" + rs.getString("TYPE_NAME"));
		
		}
		
		System.out.println("--------------------------");

		String sql = "select * from employees limit ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setInt(1, 10);
		
		rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
		}
		System.out.println("--------------------------");
		
		ResultSetMetaData rsm = rs.getMetaData();
		System.out.println(rsm.getColumnName(1));
		
	}
}
