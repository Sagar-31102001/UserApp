package com.sagar.cookie.servlet_jsp.register;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	private static Connection conn=null;
	
	private DbConnection()
	{
		super();
	}
	
	static {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(DbProperties.dbUrl,DbProperties.userName,DbProperties.passWord);
		}
		catch (Exception e) 
		{
			System.err.println("Db Connection Faild...");
		}
	}
	
	public static Connection getConnection()
	{
		return conn;
	}
}
