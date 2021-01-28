<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>DeleteExchange</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

   <script src='js/jquery.min.js'></script>
      
        
  	
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
            <a class="collapse-item" href="ManagePer.jsp">Manage Person</a> 
            <a class="collapse-item" href="ManageSch.jsp">Manage Schedule</a> 
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
    
    	
      <!-- Main Content -->
    <form action = "<%=request.getContextPath()%>/UpdateExServlet" method="get">
      	<div id="content-wrapper" class="d-flex flex-column">
      		<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Exchange</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Name1 </th>
                      <th>Name2</th>
                      <th>Date </th>
                      <th>Duration </th>
                      <th>Exchange Date</th>
                      <th>Duration</th>
                      <th> </th>
                      <th> </th>
                      
                    </tr>
                  </thead>
                  <c:forEach items="${requestScope.Lex}" var="Lex">
                  <tr>
                  	<td><c:out value="${Lex.getName1()}"/></td>
                  	<td><c:out value="${Lex.getName2()}"/></td>
                  	<td><c:out value="${Lex.getDate1()}"/></td>
                  	<td><c:out value="${Lex.getDur_id1()}"/></td>
                  	<td><c:out value="${Lex.getDate2()}"/></td>
                  	<td><c:out value="${Lex.getDur_id2()}"/></td>
                  	<td>
                  	
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck"></label>
                      </div>
                    </td>
                    <td> <a href="DeleteEx.jsp" class="btn btn-danger btn-circle">
                    <i class="fas fa-trash"></i>
                  	</a></td>	
                    
                  </tr>
                  </c:forEach>
   
      			</table>
      			
      			
      				<hr>
                <button class="btn btn-primary btn-user btn-block" id="submit" value="Submit" >
                   SAVE
                 </button>
      			
 				</div>
   				</div>
   				</div>
   				
		</div>	
		</form>
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