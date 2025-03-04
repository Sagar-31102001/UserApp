package com.sagar.servlet_jsp.editprofile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sagar.cookie.servlet_jsp.register.DbConnection;
import com.sagar.cookie.servlet_jsp.register.UserBean;

public class UpdateProfileDAO
{
	private int cnt=0;
	
	public int update(UserBean ub)
	{
		try
		{
			Connection conn = DbConnection.getConnection();
			PreparedStatement pstm = conn.prepareStatement(" UPDATE USERREG SET ADDRESS=? , MID=? , PHNO=? WHERE UNAME=? AND PWORD=?");
			
			pstm.setString(1, ub.getAddr());
			pstm.setString(2, ub.getmId());
			pstm.setLong(3, ub.getPhNo());
			pstm.setString(4, ub.getuName());
			pstm.setString(5, ub.getpWord());
			
			cnt = pstm.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		return cnt;
	}
}
	
