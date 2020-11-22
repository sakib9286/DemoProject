<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center><h3>Fill User Details ...</h3>
     <!-- User Details form -->
        
                        <form:form  action="/api/saveUserDetails" modelAttribute="userRegister" method="POST">
                             <form:hidden path="id"/>
                   
                                <label for="fname">Full Name : </label> 
                                <form:input path="fullName" name="fullName" id="fullName" /> <be/><br/><be/><br/>
                            	

 		                                <label for="email">Email : </label>  
 		                                <form:input type="email" path="email" name="email" id="email" /> <be/><br/><be/><br/>
 		                            	
 								 
		                                <label for="pass">Password : </label> 
		                                <form:password path="password" name="pass"  id="pass"/> <be/><br/><be/><br/>
		                                
		                                
	                      		<label for="gender">Gender : </label> 
                                Male: <form:radiobutton path="gender" value="Male"/>
								Female: <form:radiobutton path="gender" value="Female"/> <be/><br/><be/><br/>
							
                     
                      Interest:  
        					Cricket <form:checkbox path="interest" value="Cricket" />  
        					Football <form:checkbox path="interest" value="Football" />  
        					Carrom <form:checkbox path="interest" value="Carrom" />
        					Badminton <form:checkbox path="interest" value="Badminton" />
			
			<br/> <br/>

			<label for="department"> Department : </label>
                                <form:select path="department" name="department" id="department">
                                <form:option value="">---Select--</form:option>
	                                <form:option value="Computer Science">Computer Science</form:option>
	                                <form:option value="Mathematics">Mathematics</form:option>
	                                <form:option value="Physics">Physics</form:option>
	                                <form:option value="English">English</form:option>
	                                <form:option value="Art & Culture">Art & Culture</form:option>
	                                <form:option value="Statistics">Statistics</form:option>
                                </form:select>        <be/><br/><be/><br/>   
                
				 <input type="submit" value="register"/>
					
                             
                            
               
</table> 
                          		  
                
                </form:form>
                            
            

</body>
</center>
</html>