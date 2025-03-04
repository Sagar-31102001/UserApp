package com.sagar.cookie.servlet_jsp.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sagar.cookie.servlet_jsp.register.DbConnection;
import com.sagar.cookie.servlet_jsp.register.UserBean;

public class LoginDAO
{
	private UserBean ub=null;
	
	public UserBean login(String userName,String passWord)
	{
		
		try 
		{
			Connection conn = DbConnection.getConnection();
			PreparedStatement pstm = conn.prepareStatement(" SELECT * FROM USERREG WHERE UNAME=? AND PWORD=?");
			
			pstm.setString(1, userName);
			pstm.setString(2, passWord);
			
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next())
			{
				ub=new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
			}
		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		return ub;
	}
}