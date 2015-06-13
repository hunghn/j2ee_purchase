<%@ include file="../base/head.jsp"%>

<link href="${URL}plugins/wizard-stepbystep/bootstrap-nav-wizard.css"
	rel="stylesheet" type="text/css" />
</head>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/css/select2.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-css/1.4.6/select2-bootstrap.min.css"
	rel="stylesheet" />
</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Header -->
		<%@ include file="../base/header.jsp"%>
		<!-- /.Header -->

		<!-- Menu -->
		<%@ include file="../base/menu.jsp"%>
		<!-- /.Menu -->

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Incomning Product / New</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Incoming Product</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="margin">
							<a href="/save.do" class="btn btn-primary">Save</a> <span>or</span>
							<a href="/discard.do" class="btn btn-warning">Discard</a>
						</div>
						<div class="box">
							<div class="box-header with-border">
								<div class="col-xs-6">
									<a href="#" class="btn btn-default">Process Later</a> <a
										href="#" class="btn btn-default">Process Entirely</a> <a
										href="#" class="btn btn-default">Cancel Move</a>
								</div>
								<div class="col-xs-6">
									<ul class="nav nav-wizard">
										<li class="active"><a href="#">New</a></li>
										<li><a href="#">Waiting Availability</a></li>
										<li><a href="#">Available</a></li>
										<li><a href="#">Done</a></li>
									</ul>
								</div>
							</div>
							<div class="box-body">
								<div class="form-horizontal">

									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Product</label>
											</div>
											<div class="col-md-6">
												<select class="form-control select2">
													<option></option>
													<option value="AK">Ram</option>
													<option value="HI">Laptop</option>
													<option value="CA">HeadPhone</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
													<option value="AZ">Search or create more...</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Picking Type</label>
											</div>
											<div class="col-md-6">
												<select class="form-control select2">
													<option></option>
													<option value="AK">Ram</option>
													<option value="HI">Laptop</option>
													<option value="CA">HeadPhone</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
													<option value="AZ">Search or create more...</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Quantity</label>
											</div>
											<div class="col-md-6">
												<select class="form-control select2">
													<option></option>
													<option value="AK">Ram</option>
													<option value="HI">Laptop</option>
													<option value="CA">HeadPhone</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
													<option value="AZ">Search or create more...</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Invoice Control</label>
											</div>
											<div class="col-md-6">
												<select class="form-control select2">
													<option></option>
													<option value="AK">Ram</option>
													<option value="HI">Laptop</option>
													<option value="CA">HeadPhone</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
													<option value="AZ">Search or create more...</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Description</label>
											</div>
											<div class="col-md-6">
												<select class="form-control select2">
													<option></option>
													<option value="AK">Ram</option>
													<option value="HI">Laptop</option>
													<option value="CA">HeadPhone</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
													<option value="AZ">Search or create more...</option>
												</select>
											</div>
										</div>
									</div>


									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Priority</label>
											</div>
											<div class="col-md-6">
												<select class="form-control select2">
													<option></option>
													<option value="AK">Ram</option>
													<option value="HI">Laptop</option>
													<option value="CA">HeadPhone</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
													<option value="AZ">Search or create more...</option>
												</select>
											</div>
										</div>

									</div>

									<div class="col-xs-6">
										<div class="form-group">
											<div class="col-xs-4">
												<label>Expected Date:</label>
											</div>
											<div class="col-xs-6">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input type="text" class="form-control"
														data-inputmask="'alias': 'dd/mm/yyyy'" data-mask="">
												</div>
											</div>
										</div>
										<!-- /.input group -->
									</div>
								</div>
							</div>

						</div>
						<div class="row margin">
							<div class="col-xs-6">
								<div class="row">
									<h2>Origin</h2>
								</div>
								<div class="row form-group">
									<div class="col-xs-4">
										<label>Source Document</label>
									</div>
									<div class="col-xs-6">
										<input type="text" class="form-control"
											placeholder="Enter ...">
									</div>
									<!-- /.input group -->
								</div>
								<div class="row form-group">
									<div class="col-xs-4">
										<label>Source Location</label>
									</div>
									<div class="col-md-6">
										<select class="form-control select2">
											<option></option>
											<option value="AK">Ram</option>
											<option value="HI">Laptop</option>
											<option value="CA">HeadPhone</option>
											<option value="NV">Nevada</option>
											<option value="OR">Oregon</option>
											<option value="WA">Washington</option>
											<option value="AZ">Search or create more...</option>
										</select>
									</div>
								</div>

								<div class="row form-group">
									<div class="col-xs-4">
										<label>Transfer Reference</label>
									</div>
									<div class="col-md-6">
										<select class="form-control select2">
											<option></option>
											<option value="AK">Ram</option>
											<option value="HI">Laptop</option>
											<option value="CA">HeadPhone</option>
											<option value="NV">Nevada</option>
											<option value="OR">Oregon</option>
											<option value="WA">Washington</option>
											<option value="AZ">Search or create more...</option>
										</select>
									</div>
								</div>

								<div class="row form-group">
									<div class="col-xs-4">
										<label>Procurement Group</label>
									</div>
									<div class="col-md-6">
										<select class="form-control select2">
											<option></option>
											<option value="AK">Ram</option>
											<option value="HI">Laptop</option>
											<option value="CA">HeadPhone</option>
											<option value="NV">Nevada</option>
											<option value="OR">Oregon</option>
											<option value="WA">Washington</option>
											<option value="AZ">Search or create more...</option>
										</select>
									</div>
								</div>

							</div>
							<div class="col-xs-6">

								<div class="row">
									<h2>Destination</h2>
								</div>
								<div class="row form-group">
									<div class="col-xs-4">
										<label>Destination Location</label>
									</div>
									<div class="col-md-6">
										<select class="form-control select2">
											<option></option>
											<option value="AK">Ram</option>
											<option value="HI">Laptop</option>
											<option value="CA">HeadPhone</option>
											<option value="NV">Nevada</option>
											<option value="OR">Oregon</option>
											<option value="WA">Washington</option>
											<option value="AZ">Search or create more...</option>
										</select>
									</div>
								</div>

								<div class="row form-group">
									<div class="col-xs-4">
										<label>Destination Address</label>
									</div>
									<div class="col-md-6">
										<select class="form-control select2">
											<option></option>
											<option value="AK">Ram</option>
											<option value="HI">Laptop</option>
											<option value="CA">HeadPhone</option>
											<option value="NV">Nevada</option>
											<option value="OR">Oregon</option>
											<option value="WA">Washington</option>
											<option value="AZ">Search or create more...</option>
										</select>
									</div>
								</div>
								
								<div class="row form-group">
									<div class="col-xs-4">
										<label>Purchase Order Line</label>
									</div>
									<div class="col-md-6">
										<select class="form-control select2">
											<option></option>
											<option value="AK">Ram</option>
											<option value="HI">Laptop</option>
											<option value="CA">HeadPhone</option>
											<option value="NV">Nevada</option>
											<option value="OR">Oregon</option>
											<option value="WA">Washington</option>
											<option value="AZ">Search or create more...</option>
										</select>
									</div>
								</div>
							</div>
						</div>

					</div>

				</div>

			</div>
			<div class="row"></div>
			<div class="row"></div>
		</div>
	</div>

	</div>
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
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/js/select2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".select2").select2({
				placeholder : "Select a product"
			});
		});
	</script>
</body>
</html>