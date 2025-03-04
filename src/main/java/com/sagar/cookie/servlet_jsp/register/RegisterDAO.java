package com.sagar.cookie.servlet_jsp.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO 
{
	private int k=0;
	public int register(UserBean ub)
	{
		try 
		{
			Connection conn = DbConnection.getConnection();
			PreparedStatement pstm = conn.prepareStatement(" INSERT INTO USERREG VALUES (?,?,?,?,?,?,?)");
			pstm.setString(1, ub.getuName());
			pstm.setString(2, ub.getpWord());
			pstm.setString(3, ub.getfName());
			pstm.setString(4, ub.getlName());
			pstm.setString(5, ub.getAddr());
			pstm.setString(6, ub.getmId());
			pstm.setLong(7, ub.getPhNo());
			
			k=pstm.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		return k;
	}
}
