package com.sagar.servlet_jsp.editprofile;

import java.io.IOException;
import java.io.PrintWriter;

import com.sagar.cookie.servlet_jsp.register.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Cookie[] ck = req.getCookies();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(ck!=null)
		{
			req.setAttribute("ckName", ck[0].getValue());
			UserBean ub = (UserBean)req.getServletContext().getAttribute("userBean");
			
			ub.setAddr(req.getParameter("address"));
			ub.setmId(req.getParameter("mid"));
			ub.setPhNo(Long.parseLong(req.getParameter("mobileno")));
			
			
			int cnt = new UpdateProfileDAO().update(ub);
			
			if (cnt > 0) 
			{
				pw.println("<script type='text/javascript'>"); 
					pw.println("alert('Your Profile Update Successfully...')");
					pw.println("location='Login.jsp';"); 
				pw.println("</script>"); 
			} 
			else 
			{
				pw.println("<script type='text/javascript'>"); 
					pw.println("alert('Your Profile Update Failed...')");
					pw.println("location='Login.jsp';"); 
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
