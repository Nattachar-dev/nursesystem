<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="login.database.Connect" %>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>LeaveWork</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <script src='js/jquery.min.js'></script>
  
  <!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
  

      <link rel="stylesheet" type="text/css" href="dropdown/stb.dropdown.min.css">
      <script type="text/javascript" src="dropdown/stb.dropdown.min.js"></script> 
      
      
      <script type="text/javascript">
         jQuery(document).ready(function ($) {
            $("select").stbDropdown();
         });
      </script>
      
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
    <!-- End of Sidebar -->
    
   
 	  	 <!-- Content Wrapper -->
 	  	 
 	  	 

    <div id="content-wrapper" class="d-flex flex-column">
    

    	
      <!-- Main Content -->
      	 
      <form id=from action="<%=request.getContextPath()%>/LeaveServlet" method="get"> 	
      
      
      
          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Leave Duty</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                  </div>
                </div>
                <!-- Card Body -->
                
                <div class="card-body">
                
               
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="name" placeholder="Name">
                  </div>
                  <select class="form-control" name="pos" id= "pos">
                                <option>Select Duration</option>
                                <%
                               
                                Connect dbConnect = new Connect();
                                Connection con = dbConnect.connect();

                                String sqlText1 ="select pos_id,pos_name from position where pos_id between 1 and 3";
                                Statement statement1 = con.createStatement();
                                ResultSet rs1= statement1.executeQuery(sqlText1);
                                while(rs1.next()){
                                    %>
                                    <option value ='<%=rs1.getString("pos_id")%>'><%=rs1.getString("pos_name")%></option>
                                    
                                    <% 
                                    }
                                %>
                                
                                
                 </select>
                </div>
                
                <div class="form-group">
                  <input  class="form-control form-control-user" id="description" placeholder="Description...">
                </div>
                
                <div class="form-group"> <!-- Date input -->
					<input class="form-control bg-light border-0 small" id="date1" name="date" placeholder="MM/DD/YYY" type="text"/>
				</div>
				
				<select class="form-control" name="dur1" id= "dur1">
                                <option>Select Duration</option>
                                <%
                               
                                Connect db1Connect = new Connect();
                                Connection connection = db1Connect.connect();

                                String sqlText ="select dur_id,dur_name from duration";
                                Statement statement = connection.createStatement();
                                ResultSet rs= statement.executeQuery(sqlText);
                                while(rs.next()){
                                    %>
                                    <option value ='<%=rs.getString("dur_id")%>'><%=rs.getString("dur_name")%></option>
                                    
                                    <% 
                                    }
                                %>
                                
                                
                 </select>
                  
                    
                    
                    
                    
                    
                                 
				<hr>
                <button class="btn btn-primary btn-user btn-block" id="submit" value="Submit" >
                   Sent
                 </button>

                  </div>
                </div>
              </div>
            </div>
      
     
      
      
      
      
      

       

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