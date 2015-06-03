<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<c:choose>
	<c:when test="${not empty sessionScope['USERLOGIN']}">
	</c:when>
	<c:otherwise>
		<c:redirect url="/" />
	</c:otherwise>
</c:choose>
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
				<h1>${PAGE_NAME}</h1>
				<ol class="breadcrumb">
					<li><a href="${BASE_URL}home.do"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">${PAGE_NAME}</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header with-border">
								<button class="btn btn-primary" id="erpModalPopupButton">Create</button>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="dt_lstCompany"
									class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Name</th>
											<th>Phone</th>
											<th>Email</th>
											<th>Address</th>
											<th>Action</th>
										</tr>
									</thead>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
			</section>
			<!-- /.content -->

			<!-- Modal -->
			<div class="modal fade" id="erpModalPopup" tabindex="-1"
				role="dialog" aria-labelledby="erpModalPopupLabel"
				aria-hidden="true"></div>
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
	<!-- Bootstrap validator -->
	<script
		src='${URL}plugins/bootstrap-validator/js/bootstrapValidator.min.js'></script>
	<!-- page script -->
	<script src="${URL}js/erp_company.js" type="text/javascript"></script>
</body>
</html>