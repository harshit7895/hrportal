<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>



<body style="background-color:lightpink;">

	<p style="font-size:50px; padding-left:300px; color:darkgreen;">Human Resource Management System</p>

<div style="padding-top:50px;width:40%; padding-left:330px; ">

	<fieldset style="border: 4px solid blue;   ">

<form name ="form" action="logout" method="post">
<%
String message = request.getParameter("MESSAGE");
if(message != null && !message.trim().equals("")) {
%>
<div style="text-align:center;color:green; width:80%; font-size:25px; padding-left:70px; "><p ><%=message %></p></div>
<%	
}
%>
   <table align="center" style="margin:50px; padding-left:40px;">
   
     <tr>
          
        <td style="font-size:30px;">Username</td>
        <td><input style="width:300px;  padding:8px; border:2px solid orange; margin-left:8px;" type="text"  name="username" /></td>
           
      </tr>
        
           <tr>
                  
              <td style="font-size:30px;">Password</td>
              <td><input style="width:300px; padding:8px; border:2px solid orange; margin-left:8px" type="password" name="password" /></td>
           </tr>
           
              <tr>
                
                  <td><span style="color:red"><%=(request.getAttribute("errormessage") == null) ?"" : request.getAttribute("errormessage")%></span></td>
            </tr>
            <tr>
            
            <td></td>
            
               <td><input type="submit" value="Login" style="border:2px solid; border-color:red; margin-left:70px;  width: 80px; font-size:25px;"></input>
               <input type="reset" value="Reset" style="border:2px solid; border-color:red; margin:10px;  width: 85px; font-size:25px;"></input></td>
              
            </tr>            
       </table>
 
    </form>
    </fieldset>
    </div>
   

  </body>

</html>
