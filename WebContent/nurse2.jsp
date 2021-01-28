<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import ="login.database.Connect" %>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP Page</title>

</head>
<body>

	
                      
                      <select class="form-control" name= "nurse2" id="nurse2">
                      			<option>Select Name</option>
                                <%  
                                Connect db2Connect = new Connect();
                                Connection connection = db2Connect.connect();
                                
                                String sqlText ="select username,name from nurse";
                                Statement statement = connection.createStatement();
                                ResultSet rs= statement.executeQuery(sqlText);
                                while(rs.next()){
                                    %>
                                    <option value ='<%=rs.getString("username")%>'><%=rs.getString("name")%></option>
                                    
                                    <% 
                                    }
                                

                                %>

                            </select>
                            
                  
                   

</body>
</html>