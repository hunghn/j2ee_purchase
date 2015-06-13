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
				<h1>Call For Tenders / New</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Call For Tenders</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="box content">
				<div class="row">
					<div class="col-xs-12">
						<div class="margin">
							<a href="/save.do" class="btn btn-primary">Save</a> <span>or</span>
							<a href="/discard.do" class="btn btn-warning">Discard</a>
						</div>
						<div class="box">
							<div class="box-header with-border">
								<div class="col-xs-6">
									<a href="#" class="btn btn-default">Confirm Call</a> <a
										href="#" class="btn btn-default">Cancel Call</a>
								</div>
								<div class="col-xs-6">
									<ul class="nav nav-wizard">
										<li class="active"><a href="#">Draft</a></li>
										<li><a href="#">Confirmed</a></li>
										<li><a href="#">Bid Selection</a></li>
										<li><a href="#">PO Created</a></li>
									</ul>
								</div>
							</div>
							<div class="box-body">
								<div class="form-horizontal">
									<div class="row margin">

										<div class="col-xs-6">
											<div class="form-group">
												<label>Call for Tenders Reference</label> <input type="text"
													class="form-control col-xs-5" value="TE00001">
											</div>
											<div class="row form-group">
												<div class="col-xs-4">
													<label>Responsible</label>
												</div>
												<div class="col-md-6">
													<select class="form-control">
														<option>Administrator</option>
														<option>User</option>
														<option>Accounting</option>
														<option>Purchase Manager</option>
														<option>Director</option>
													</select>
												</div>
											</div>
											<div class="row form-group">
												<div class="col-xs-4">
													<label>Tender Selection Type</label>
												</div>
												<div class="col-xs-6">
													<select class="form-control">
														<option>Select Multiple RFQ</option>
														<option>Select Only RFQ</option>
													</select>
												</div>
												<!-- /.input group -->
											</div>
											<div class="row form-group">
												<div class="col-xs-4">
													<label>Multiple RFQ per supplier</label>
												</div>
												<div class="col-xs-6">
													<div class="checkbox">
														<label> <input type="checkbox">
														</label>
													</div>
												</div>
												<!-- /.input group -->
											</div>
										</div>
										<div class="col-xs-6">

											<div class="row">
												<h2>Date</h2>
											</div>
											<div class="row form-group">
												<div class="col-xs-4">
													<label>Tender Closing Deadline</label>
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
												<!-- /.input group -->
											</div>

											<div class="row form-group">
												<div class="col-xs-4">
													<label>Scheduled Ordering Date</label>
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
												<!-- /.input group -->
											</div>
											<div class="row form-group">
												<div class="col-xs-4">
													<label>Scheduled Date</label>
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
												<!-- /.input group -->
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
										</div>
									</div>

								</div>

							</div>

						</div>
						<div class="row"></div>
						<div class="row"></div>
					</div>
				</div>
				<div class="margin row form-group">
					<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
						<li class="active"><a href="#invoice" data-toggle="tab">Products</a></li>
					</ul>
					<div id="my-tab-content" class="tab-content">
						<div class="tab-pane active" id="invoice">
							<div class="row box-body">
								<table id="dt_lstDraftInvoice"
									class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Product</th>
											<th>Quantity</th>
											<th>Scheduled Date</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Vicking Direct</td>
											<td>05/30/2015</td>
											<td></td>
										</tr>
										<tr>
											<td>Asus Tek</td>
											<td>05/30/2015</td>
											<td></td>
										</tr>
										<tr>
											<td>Apple Inc</td>
											<td>05/30/2015</td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							</div>
							<div>
							<h2>Requests for Quotation</h2>
							<div class="row">
									<div class="box-body">
										<table id="dt_lstDraftInvoice"
											class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>Reference</th>
													<th>Order Date</th>
													<th>Supplier</th>
													<th>Destination</th>
													<th>Source Document</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Vicking Direct</td>
													<td>05/30/2015</td>
													<td></td>
													<td>Administrator</td>
													<td></td>
													<td>Administrator</td>
												</tr>
												<tr>
													<td>Asus Tek</td>
													<td>05/30/2015</td>
													<td></td>
													<td>Public User</td>
													<td></td>
													<td>Administrator</td>
												</tr>
												<tr>
													<td>Apple Inc</td>
													<td>05/30/2015</td>
													<td></td>
													<td>Director</td>
													<td></td>
													<td>Administrator</td>
												</tr>
											</tbody>
										</table>
									</div>
								
							</div>
						</div>
						<div class="tab-pane" id="payments">
							<div class="row box-body">
								<table id="dt_lstDraftInvoice"
									class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Payment Date</th>
											<th>Reference</th>
											<th>Name</th>
											<th>Debit</th>
											<th>Credit</th>
											<th>Source Document</th>
											<th>Amount</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Vicking Direct</td>
											<td>05/30/2015</td>
											<td></td>
											<td>Administrator</td>
											<td>01/30/2015</td>
											<td>PO00006</td>
											<td>1,335,000</td>
										</tr>
										<tr>
											<td>Asus Tek</td>
											<td>05/30/2015</td>
											<td></td>
											<td>Public User</td>
											<td>03/15/2015</td>
											<td>PO2015</td>
											<td>2,500,000</td>
										</tr>
										<tr>
											<td>Apple Inc</td>
											<td>05/30/2015</td>
											<td></td>
											<td>Director</td>
											<td>01/30/2015</td>
											<td>PO0007</td>
											<td>50,000,000</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
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
				jQuery(document).ready(function($) {
					$('#tabs').tab();
				});
			</script>
			<script type="text/javascript">
				$(document).ready(function() {
					$(".select2").select2({

						placeholder : "Select a object"
					});
				});
			</script>
			<script type="text/javascript">
				$(function() {
					$("#dt_lstDraftInvoice").dataTable();
				});
			</script>
</body>
</html>