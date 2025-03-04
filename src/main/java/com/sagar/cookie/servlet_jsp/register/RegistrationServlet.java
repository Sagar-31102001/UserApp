package com.sagar.cookie.servlet_jsp.register;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException , IOException
	{
		UserBean ub = new UserBean();
		
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("password"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("address"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("mobileno")));
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		int cnt = new RegisterDAO().register(ub);
		
		if(cnt > 0) 
		{
			pw.println("<script type='text/javascript'>"); 
				pw.println("alert('Registration Successfully...')");
				pw.println("location='Register.jsp';"); 
			pw.println("</script>"); 
		}
		else 
		{
			
			pw.println("<script type='text/javascript'>"); 
				pw.println("alert('Registration Failed... // User-Name Already Exist...')");
				pw.println("location='RepeatedRegisterPage.jsp';"); 
			pw.println("</script>"); 
		}
		
	}
}
