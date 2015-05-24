<%@ include file="./base/head.jsp"%>

</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Header -->
		<%@ include file="./base/header.jsp"%>
		<!-- /.Header -->

		<!-- Menu -->
		<%@ include file="./base/menu.jsp"%>
		<!-- /.Menu -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Dashboard</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Dashboard</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content"></section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Footer -->
		<%@ include file="./base/footer.jsp"%>
		<!-- /.Footer -->

	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.3 -->
	<script src="${URL}plugins/jQuery/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="${URL}bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script src='${URL}plugins/fastclick/fastclick.min.js'></script>
	<!-- AdminLTE App -->
	<script src="${URL}dist/js/app.min.js" type="text/javascript"></script>


</body>
</html>