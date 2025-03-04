package com.sagar.cookie.servlet_jsp.viewprofile;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Cookie[] ck = req.getCookies();
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if (ck!=null) 
		{
			req.setAttribute("ckName",ck[0].getValue());
			System.out.println(ck[0].getValue());
			req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
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
