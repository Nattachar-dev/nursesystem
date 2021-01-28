<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import ="login.database.Connect" %>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP Page</title>

<script src='js/jquery.min.js'></script>
  

</head>
<body>

	
   
                      <select class="form-control" name= "nurse1" id="nurse1">
                      		<option>Select Name1</option>
                                <%
                               
                                Connect db1Connect = new Connect();
                                Connection connection = db1Connect.connect();
                                
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
                            
                     
                     
       
<script>
    $(document).ready(function () {
        $("#nurse1").on("change", function () {
            var nurse1_id = $("#nurse1").val();
                $("#error").html("");
                $.ajax({
                    url: "nurse2.jsp",
                    method: "POST",
                    data: {nurse1_id:nurse1_id},
                    success: function (data)
                    {
                        $("#nurse2_id").html(data);
                    }
                });
        });
    });
</script>

</body>
</html>
