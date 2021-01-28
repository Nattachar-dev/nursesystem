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

  <title>AllSch</title>

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
      	
      	<div id="content-wrapper" class="d-flex flex-column">
      		<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Schedule Tables</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                    
                      <th>NAME</th>
                      <th>D1</th>
                      <th>D2</th>
                      <th>D3</th>
                      <th>D4</th>
                      <th>D5</th>
                      <th>D6</th>
                      <th>D7</th>
                      <th>D8</th>
                      <th>D9</th>
                      <th>D10</th>
                      <th>D11</th>
                      <th>D12</th>
                      <th>D13</th>
                      <th>D14</th>
                      <th>D15</th>
                      <th>D16</th>
                      <th>D17</th>
                      <th>D18</th>
                      <th>D19</th>
                      <th>D20</th>
                      <th>D21</th>
                      <th>D22</th>
                      <th>D23</th>
                      <th>D24</th>
                      <th>D25</th>
                      <th>D26</th>
                      <th>D27</th>
                      <th>D28</th>
                      <th>D29</th>
                      <th>D30</th> 

 
                    </tr>
                  </thead>
                  <c:forEach items="${requestScope.mySch}" var="mySch">
                  <tr>
                  	<td><c:out value="${mySch.getName_id()}"/></td>
                    <td><c:out value="${mySch.getD1()}"/></td>
                    <td><c:out value="${mySch.getD2()}"/></td>
                    <td><c:out value="${mySch.getD3()}"/></td>
                    <td><c:out value="${mySch.getD4()}"/></td>
                    <td><c:out value="${mySch.getD5()}"/></td>
                    <td><c:out value="${mySch.getD6()}"/></td>
                    <td><c:out value="${mySch.getD7()}"/></td>
                    <td><c:out value="${mySch.getD8()}"/></td>
                    <td><c:out value="${mySch.getD9()}"/></td>
                    <td><c:out value="${mySch.getD10()}"/></td>
                    <td><c:out value="${mySch.getD11()}"/></td>
                    <td><c:out value="${mySch.getD12()}"/></td>
                    <td><c:out value="${mySch.getD13()}"/></td>
                    <td><c:out value="${mySch.getD14()}"/></td>
                    <td><c:out value="${mySch.getD15()}"/></td>
                    <td><c:out value="${mySch.getD16()}"/></td>
                    <td><c:out value="${mySch.getD17()}"/></td>
                    <td><c:out value="${mySch.getD18()}"/></td>
                    <td><c:out value="${mySch.getD19()}"/></td>
                    <td><c:out value="${mySch.getD20()}"/></td>
                    <td><c:out value="${mySch.getD21()}"/></td>
                    <td><c:out value="${mySch.getD22()}"/></td>
                    <td><c:out value="${mySch.getD23()}"/></td>
                    <td><c:out value="${mySch.getD24()}"/></td>
                    <td><c:out value="${mySch.getD25()}"/></td>
                    <td><c:out value="${mySch.getD26()}"/></td>
                    <td><c:out value="${mySch.getD27()}"/></td>
                    <td><c:out value="${mySch.getD28()}"/></td>
                    <td><c:out value="${mySch.getD29()}"/></td>
                    <td><c:out value="${mySch.getD30()}"/></td>
                  	
                  </tr>
                  </c:forEach>
   
      			</table>
   				</div>
   				</div>
   				
   				</div>
   				
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