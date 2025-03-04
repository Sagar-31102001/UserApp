package com.sagar.cookie.servlet_jsp.login;

import java.io.IOException;
import java.io.PrintWriter;

import com.sagar.cookie.servlet_jsp.register.UserBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		String userName=req.getParameter("email");
		String passWord=req.getParameter("password");
		
		UserBean ub = new LoginDAO().login(userName, passWord);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if (ub!=null)
		{
			// Here Collect ServletContextObject
			ServletContext sct = req.getServletContext();
			sct.setAttribute("userBean", ub);//Adding Bean Object to Context (HAS-A Relation)
			
			Cookie ck=new Cookie("fname",ub.getfName()); // Here Internally Perform The Serializable Process
			res.addCookie(ck); // Adding The Cookie To The Response 
			
			pw.println("<script type='text/javascript'>"); 
				pw.println("alert('Login Successfully...')");
				pw.println("location='Login.jsp';"); 
			pw.println("</script>"); 
			
		} 
		else 
		{
			pw.println("<script type='text/javascript'>"); 
				pw.println("alert('Login Failed...')");
				pw.println("location='RepeatedLoginPage.jsp';"); 
			pw.println("</script>"); 
		}
		
	}
}
