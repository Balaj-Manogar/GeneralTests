package org.baali.demos.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		System.out.println("Tables");
		System.out.println("---------------");
		while(rs.next())
		{
			System.out.println(rs.getString(3));
			i++;
		}
		
		
	}
}
