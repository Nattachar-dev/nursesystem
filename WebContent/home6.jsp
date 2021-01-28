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

  <title>Home6</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
    
  <!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
  
  

		<link href='css/fullcalendar.min.css' rel='stylesheet' />
        <link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
        <script src='js/moment.min.js'></script>
        <script src='js/jquery.min.js'></script>
        <script src='js/fullcalendar.min.js'></script>
        
        <link rel="stylesheet" type="text/css" href="dropdown/stb.dropdown.min.css">
      <script type="text/javascript" src="dropdown/stb.dropdown.min.js"></script> 
      
      
      <script type="text/javascript">
         jQuery(document).ready(function ($) {
            $("select").stbDropdown();
         });
      </script>
       
      
           <script>
            jQuery(document).ready(function (){
            	
                $('#calendar').fullCalendar({
                	themeSystem: 'bootstrap4',
                	header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay',
                        
                    },
                    
                    defaultDate: '2020-01-12',
                    editable: true,
                    eventLimit: true, // allow "more" link when too many events
                    events: [{title:"เช้า",start:"2020-01-01"},{title:"หยุด",start:"2020-01-02"},{title:"บ่าย","date":"2020-01-03","id":2},{title:"เช้า","date":"2020-01-04","id":3},{title:"หยุด","date":"2020-01-05","id":4},{title:"เช้า","date":"2020-01-06","id":5},{title:"เช้า","date":"2020-01-07","id":6},{title:"บ่าย","date":"2020-01-08","id":7},{title:"ดึก","date":"2020-01-09","id":8},{title:"หยุด","date":"2020-01-10","id":9},{title:"เช้า","date":"2020-01-11","id":10},{title:"เช้า","date":"2020-01-12","id":11},{title:"ดึก","date":"2020-01-13","id":12},{title:"หยุด","date":"2020-01-14","id":13},{title:"หยุด","date":"2020-01-15","id":14},{title:"ดึก","date":"2020-01-16","id":15},{title:"บ่าย","date":"2020-01-17","id":16},{title:"เช้า","date":"2020-01-18","id":17},{title:"หยุด","date":"2020-01-19","id":18},{title:"ดึก","date":"2020-01-20","id":19},{title:"ดึก","date":"2020-01-21","id":20},{title:"ดึก","date":"2020-01-22","id":21},{title:"เช้า","date":"2020-01-23","id":22},{title:"ดึก","date":"2020-01-24","id":23},{title:"บ่าย","date":"2020-01-25","id":24},{title:"ดึก","date":"2020-01-26","id":25},{title:"หยุด","date":"2020-01-27","id":26},{title:"เช้า","date":"2020-01-28","id":27},{title:"บ่าย","date":"2020-01-29","id":28},{title:"ดึก","date":"2020-01-30","id":29}],
  					select: function(date){
  						var getdate = (date.format());
  						$('#exampleModal').modal({show: 'false'});
  					}
                });
                

            });

        </script>
        
        
        <style>
        
		#calendar{
			max-width: 900px;
			margin: 0 auto  ;
				
		}

</style>



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
  			
  
  
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Register</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="form-group"> <!-- Date input -->
						        <input class="form-control bg-light border-0 small" id="date1" name="date" placeholder="MM/DD/YYY" type="text"/>
						 </div>
				
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
						 
						 
						 
						 
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save </button>
		      </div>
		    </div>
		  </div>
		</div>
		  
  
  
    
    <!-- Sidebar -->
    
    
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    
    


      <!-- Nav Item - Dashboard -->
      
      <li class="nav-item active">
      
        <a class="nav-link" href="home2.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Duty Schedule  </span></a> 
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
      
      
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <span class="badge badge-danger badge-counter">1+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Notify !  
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">January 12, 2020</div>
                    <span class="font-weight-bold">Your are Nurse in charge!</span>
                  </div>
                </a>
      
 
    </ul>





    	
      <!-- Main Content -->
      <div id="content-wrapper" class="d-flex flex-column">
      	  <div class="container-fluid">
			

			<div class="row">
                <div class="col-lg-12">
                 <h3 class="page-header alert btn-info"><i class="fa fa-calendar fa-fw"></i> Calendar <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  					Sign
				</button></h3>
                 
                </div>
     		</div>
     		
     		<div class="row">
        			<div id='calendar'></div>
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