<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.sagar.cookie.servlet_jsp.register.UserBean"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login User</title>
		<style>
			body {
				 background-color:rgb(172, 185, 213);
			}
			h3{
				color :rgb(238, 66, 66) ;
				border : 2px solid blue;
				border-radius : 5px;
				background-color:rgba(211, 211, 211, 0.753);
				height : 30px;
				text-align : center;
				padding :5px;
				box-shadow: -2px -2px;
			}
			div{
				border : 3px solid blue;
				border-radius : 10px;
				display:block;
				margin : auto;
				margin-top : 5%;
				padding : 20px;
				text-align : center;
				width : 300px;
				height : 150px;
				box-shadow: 2px 2px;
			}
		</style>
	</head>
	<body>
		<div>
			<%
				UserBean ub=(UserBean)application.getAttribute("userBean");
			%>
			<h3>
				<%
					out.println("Welcome User : "+ub.getfName()+" !!!<br>");
				%>
			</h3>
			<br>
			<%@include file="ViewProfile.html" %>
		</div>
		
	</body>
</html>