<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parshwabhoomi - Context Based Search: User Login</title>
    </head>
    <body>
        <h2 align="center">Parshwabhoomi - Context Based Search: Register</h2>
        <%
            String username="";
            String password="";
            if(session.getAttribute("invalidCreds") != null){
            	//This means the creds were invalid.
                username = (String)session.getAttribute("username");
                password = (String)session.getAttribute("password");
                //Invalidate the session here.
                session.invalidate();
        %>
        <h3 align="center">Couldn't sign up! Please try again.</h3>
        <%
            }
        %>
        <div align="center">
            <form method="post" action="Profile.jsp">
            	<input type="hidden" name="from" value="signup"> 
                Username : <input name="username" type="text" value="<%=username%>"><br/><br/>
                Password : <input name="password" type="password" value="<%=password%>"><br/><br/> 
                <select name="userType">
					<option value="END_USER" selected>User</option>
					<option value="BUSINESS_ENTITY">Vendor</option>
				</select> 
				<br/><br/>
                <input type="submit" value="Sign Up">
            </form>
            <br/>
        </div>
    </body>
</html>
