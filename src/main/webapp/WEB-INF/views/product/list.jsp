<%@ include file="../base/head.jsp"%>

<!-- DATA TABLES -->
<link href="${URL}plugins/datatables/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Header -->
		<%@ include file="../base/header.jsp"%>
		<!-- /.Header -->

		<!-- Menu -->
		<%@ include file="../base/menu.jsp"%>
		<!-- /.Menu -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>List Product</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">List Product</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header with-border">
								<a href="./create.do" class="btn btn-primary">Create</a>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="dt_lstProduct"
									class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Name</th>
											<th>Internal Category</th>
											<th>Product Type</th>
											<th>Status</th>
											<th>Quantity On Hand</th>
											<th>Quantity Available</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Laptop</td>
											<td>All</td>
											<td>Service</td>
											<td></td>
											<td>0.000</td>
											<td>0.000</td>
										</tr>
										<tr>
											<td>Laptop</td>
											<td>All</td>
											<td>Service</td>
											<td></td>
											<td>0.000</td>
											<td>0.000</td>
										</tr>
										<tr>
											<td>Laptop</td>
											<td>All</td>
											<td>Service</td>
											<td></td>
											<td>0.000</td>
											<td>0.000</td>
										</tr>
										<tr>
											<td>Laptop</td>
											<td>All</td>
											<td>Service</td>
											<td></td>
											<td>0.000</td>
											<td>0.000</td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->


		<!-- Footer -->
		<%@ include file="../base/footer.jsp"%>
		<!-- /.Footer -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.3 -->
	<script src="${URL}plugins/jQuery/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="${URL}bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- DATA TABES SCRIPT -->
	<script src="${URL}plugins/datatables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script src="${URL}plugins/datatables/dataTables.bootstrap.min.js"
		type="text/javascript"></script>
	<!-- SlimScroll -->
	<script src="${URL}plugins/slimScroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script src='${URL}plugins/fastclick/fastclick.min.js'></script>
	<!-- AdminLTE App -->
	<script src="${URL}dist/js/app.min.js" type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
		$(function() {
			$("#dt_lstProduct").dataTable();
		});
	</script>

</body>
</html>