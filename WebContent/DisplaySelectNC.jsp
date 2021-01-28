<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="login.database.Connect" %>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	<meta name="author" content="">
<title>DisplaySelectNC</title>


<!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

   <script src='js/jquery.min.js'></script>
   <!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

	  <script>
	    $(document).ready(function(){
	      var date_input=$('input[name="date"]'); //our date input has the name "date"
	      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	      var options={
	        format: 'mm/dd/yyyy',
	        container: container,
	        todayHighlight: true,
	        autoclose: true,
	      };
	      date_input.datepicker(options);
	    })
	</script>


</head>
<body>
<body id="page-top">

	
  <!-- Page Wrapper -->
  <div id="wrapper">
  
  
  
        <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">


      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/MySchServlet">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Duty Schedule</span></a>
      </li>

 

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Schedule</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Schedule:</h6>
            <a class="collapse-item" href="<%=request.getContextPath()%>/AllSchServlet">All Schedule</a> 
            
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="ExchangeDuty.jsp">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Duty Exchange</span>
        </a>
        
      </li>


      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="LeaveWork.jsp">
          <i class="fas fa-arrow-right"></i>
          <span>Leave</span>
        </a>
      </li>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="Checkinfo.jsp" >
          <i class="fas fa-info-circle"></i>
          <span>Verify Data</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="CheckByNC.jsp" >
          <i class="fas fa-check"></i>
          <span>Check Sign</span></a>
      </li>
      
      
     
      <li class="nav-item">
       
        <a class="nav-link" href="<%=request.getContextPath()%>/NuresListServlet">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span></a>
           
      </li>
     
      
     
      
      <li class="nav-item">
        <a class="nav-link" href="login.jsp">
          <span>Logout</span></a>
      </li>
      
      
    </ul>
    
    
    
    	<!-- Main Content -->
    	<div id="content-wrapper" class="d-flex flex-column">
      		<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Select Nurse in Charge</h6>
            </div>
            <div class="card-body">
     					
     					<div class="col-lg-6 mb-4">
		                  <div class="card bg-info text-white shadow">
		                    <div class="card-body">
		                      	<p><c:if test = "${updateResult}"> Select Nurse in Charge Success</c:if></p>
		                     
		                    </div>
		                  </div>
		                </div>
		                <div class="my-2"></div>
		                
					</div>
   				</div>
   				<form id=from action= "<%=request.getContextPath()%>/ListNCServlet" method="post"> 	

                    <table class="table table-hover">
                    
                    
                    	
                    	<tr>
                    	<td><div class="text-xs font-weight-bold text-primary text-uppercase mb-1">1.Date</div></td>
                    	<td>

						      <div class="form-group"> <!-- Date input -->
						        <input class="form-control bg-light border-0 small" id="date1" name="date" placeholder="MM/DD/YYY" type="text"/>
						      </div>
	     	   
                    	</td>	
                    	</tr>
                    	<tr>
                    	<td><div class="text-xs font-weight-bold text-success text-uppercase mb-1">3.Duration Time</div></td>
                    	<td>
                    			
                    			

                    	
                    			<select class="form-control" name="dur2" id= "dur2">
                                <option>Select Duration</option>
                                <%
                               
                                Connect dbConnect = new Connect();
                                Connection connection1 = dbConnect.connect();

                                String sqlText1 ="select dur_id,dur_name from duration";
                                Statement statement1 = connection1.createStatement();
                                ResultSet rs1= statement1.executeQuery(sqlText1);
                                while(rs1.next()){
                                    %>
                                    <option value ='<%=rs1.getString("dur_id")%>'><%=rs1.getString("dur_name")%></option>
                                    
                                    <% 
                                    }
                                	%>
                            	</select>
                            	         	
                    	</td>
                    	</tr>
                    	<tr>
                    	<td><div class="text-xs font-weight-bold text-warning text-uppercase mb-1">4.Select Name </div></td>
                    	<td>
                    		<select class="form-control" name="nurse">
                                <option>Select Name</option>
                                <%
                               
                                Connect db4Connect = new Connect();
                                Connection connection2 = db4Connect.connect();
          
                                String sqlText4 ="SELECT n.name, s.name_id from schedule_nurse s ,nurse n WHERE s.name_id=n.username AND s.duration= 2 AND s.day=7";
                                Statement statement4 = connection2.createStatement();
                                ResultSet rs4= statement4.executeQuery(sqlText4);
                                while(rs4.next()){
                                    %>
                                    <option value ='<%=rs4.getString("s.name_id")%>'><%=rs4.getString("n.name")%></option>
                                    
                                    <% 
                                    }
                                	%>
                            </select>
                    	</td>   
                    	</tr>
                    	
                    	<tr>
                    	
                    	
   					</table>
                    
					<hr>
                <button class="btn btn-primary btn-user btn-block" id="submit" value="Submit" >
                   SAVE
                 </button>

				</form>
   				
   				
  
		</div>	
		
    
 </div>
   


	

<!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>


  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>
</html>