<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.sagar.cookie.servlet_jsp.register.UserBean"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View Profile On User</title>
		<style>

        body{
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
            border : 2px solid blue;
            border-radius: 10px;
            width: 500px;
            height:300px;
            display: block;
            margin: auto;
            margin-top: 10%;
            padding: 10px;
            box-shadow: 2px 2px;
            text-align: center;
        }
        table{
		     width : 100%;
		     
		   }
			table, th, td {
					border: 1px solid black;
					border-collapse: collapse;
					text-align: center;
					border-radius : 5px;
					
			}
			th, td {
			  color : blue;
			  text-align : center;
			}
			th{
				color : black;
			}
            a{
				padding : 3px;
				border : 1px solid black;
				border-radius: 3px;
				text-decoration: none;
				background-color: #96D4D4;
				color : black;
				font-weight : bold;
			}
			
			a:hover {
  				background-color: blue;
  				color : white;
			}
			a:visited{
				color : red;
			}
    </style>
	</head>
	<body>
		<%
			String fname =(String)request.getAttribute("ckName");
			UserBean ub=(UserBean)application.getAttribute("userBean");
			
			// ub.getfName()
		%>
		<div>
        <h3><%out.println(ub.getfName());%> Welcome To Your Profile</h3>
        <table border="1">
            <tr>
                <th>Attribute</th>
                <th>Values</th>
            </tr>
            <tr>
                <td>User Name </td>
                <td><%out.println(ub.getuName()); %></td>
            </tr>
            <tr>
                <td>PassWord </td>
                <td><%out.println(ub.getpWord()); %></td>
            </tr>
            <tr>
                <td>First Name </td>
                <td><%out.println(ub.getfName()); %></td>
            </tr>
            <tr>
                <td>Last Name</td>
                  <td><%out.println(ub.getlName()); %></td>
            </tr>
            <tr>
                <td>Address</td>
                 <td><%out.println(ub.getAddr()); %></td>
            </tr>
            <tr>
                <td>Mail Id </td>
                 <td><%out.println(ub.getmId()); %></td>
            </tr>
            <tr>
                <td>Mobile Number </td>
                 <td><%out.println(ub.getPhNo()); %></td>
            </tr>
        </table>
        <br>
        <a href="edit">EditProfile</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout">Logout </a>
    </div>
	</body>
</html>