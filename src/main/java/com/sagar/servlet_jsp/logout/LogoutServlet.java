package com.sagar.servlet_jsp.logout;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	Cookie cookie = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Cookie[] ck = req.getCookies();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if (ck!=null)
		{
			cookie=ck[0];
			if(cookie.getName().equals("fname"))
			{
				cookie.setMaxAge(0);
				res.addCookie(cookie);
				pw.println("<script type='text/javascript'>"); 
					pw.println("alert('Logout Successfully...')");
					pw.println("location='RepeatedLoginPage.jsp';"); 
				pw.println("</script>"); 
				//req.getRequestDispatcher("RepeatedLoginPage.jsp").forward(req, res);
			}
			else
			{
				//***
				
				pw.println("<script type='text/javascript'>"); 
					pw.println("alert('Logout Successfully...')");
					pw.println("location='RepeatedLoginPage.jsp';"); 
				pw.println("</script>"); 
			}
			
		}
		else 
		{
			pw.println("<script type='text/javascript'>"); 
				pw.println("alert('Session Expried...')");
				pw.println("location='RepeatedLoginPage.jsp';"); 
			pw.println("</script>"); 
		}
	}
}
