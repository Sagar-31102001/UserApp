<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="com.sagar.cookie.servlet_jsp.register.UserBean"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Profile </title>
		<style>
            body{
                background-color:rgb(172, 185, 213);
            }
            label{
                color : blue;
                font-weight: bold;
                font-size: 18px;
            }
            div{
                border: 2px solid blue;
                border-radius: 10px;
                width: 500px;
                height: 300px;
                display: block;
                margin: auto;
                margin-top: 10%;
                box-shadow: 2px 2px;
            }
            table{
                border: 2px solid blue;
                width : 80%;
                border-radius: 10px;
                box-shadow: 2px 2px;
                margin-left: 10%;
            }
            table, th, td {
					
					text-align: center;
					
			}
            input{
                margin: 10px;
                height: 25px;
                border-radius: 5px;
            }
            h3{
                background-color: rgba(224, 217, 217, 0.753);
                border-radius: 50px;
                text-align: center;
                color :rgb(238, 66, 66) ;
                box-shadow: -2px -2px;
                margin-left: 7%;
                margin-right: 7%;
                height: 25px;
                padding : 5px;
            }
            #sub{
				padding : 3px;
				border : 1px solid black;
				border-radius: 3px;
				text-decoration: none;
				background-color: #96D4D4;
				color : black;
				font-weight : bold;
			}
            #sub:hover {
  				background-color: blue;
  				color : white;
			}
            #sub:visited{
				color : red;
			}
        </style>
        <script>
        	function numberValid()
        	{
        		var phoneno = document.myForm.mobileno.value;
        		if (!phoneno.match(/^\d{10}$/)) {
    				alert("Enter Integer Value and input<=10");
    				return false;
    			}
        		return true;
        	}
        </script>
	</head>
	<body>
		<%
			String fname=(String)request.getAttribute("ckName");
			UserBean ub=(UserBean)application.getAttribute("userBean");
		%>
		<div>
            <h3>Edit Profile</h3>
            <form action="update" name ="myForm" onsubmit="return numberValid()" method="post">
                <table>
                    <tr>
                        <td> <label for="add">Address : </label></td>
                        <td><input type="text" placeholder="Address" id="add" name="address" value="<%=ub.getAddr() %>" autofocus> </td>
                    </tr>
                    <tr>
                        <td> <label for="mid">MailId : </label></td>
                        <td><input type="text" placeholder="Email" id="mid" name="mid"  value="<%=ub.getmId()%>" required></td>
                    </tr>
                    <tr>
                        <td> <label for="phno">Mobile No : </label></td>
                        <td><input type="text" placeholder="Mobile Number" id="phno" name="mobileno" value="<%=ub.getPhNo()%>"required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <input type="submit" value="UpdateProfile" id="sub"></td>
                    </tr>
                </table>
             </form>
        </div>
	</body>
</html>