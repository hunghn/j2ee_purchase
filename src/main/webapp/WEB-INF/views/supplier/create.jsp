<%@ include file="../base/head.jsp"%>

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
				<h1>Create Supplier</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Create Supplier</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-body">
								<form role="form" class="form-horizontal">
									<div class="box-header with-border">
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group">
													<label for="InputName" class="col-sm-3 control-label">Name</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Enter name" id="txtName"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="col-xs-6">
												<div class="form-group">
													<label for="InputCompany" class="col-sm-3 control-label">Company</label>
													<div class="col-sm-9">
														<select class="form-control">
															<option>option 1</option>
															<option>option 2</option>
															<option>option 3</option>
															<option>option 4</option>
															<option>option 5</option>
														</select>
													</div>
												</div>

											</div>
										</div>
									</div>
									<div class="box-body">
										<div class="row">
											<div class="col-xs-6">

												<div class="form-group">
													<label for="InputEmail" class="col-sm-3 control-label">Email</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Email" id="txtEmail"
															class="form-control">
													</div>
												</div>

												<div class="form-group">
													<label for="InputPhone" class="col-sm-3 control-label">Phone</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Phone" id="txtPhone"
															class="form-control">
													</div>
												</div>
												<div class="form-group">
													<label for="InputMobile" class="col-sm-3 control-label">Mobile</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Mobile" id="txtMobile"
															class="form-control
                                                                   ">
													</div>
												</div>
												<div class="form-group">
													<label for="InputFax" class="col-sm-3 control-label">Fax</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Fax" id="txtFax"
															class="form-control">
													</div>
												</div>
												<div class="form-group">
													<label for="InputWebsite" class="col-sm-3 control-label">Website</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Website" id="txtWebsite"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="col-xs-6">

												<div class="form-group">
													<label for="InputJobPosition"
														class="col-sm-3 control-label">Job Position</label>
													<div class="col-sm-9">
														<input type="text" placeholder="e.g. Sales Director"
															id="txtJobPosition" class="form-control">
													</div>
												</div>
												<div class="form-group">
													<label for="InputTitle" class="col-sm-3 control-label">Title</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Title" id="txtTitle"
															class="form-control">
													</div>
												</div>
												<div class="form-group">
													<label for="InputAddress" class="col-sm-3 control-label">Address</label>
													<div class="col-sm-9">
														<input type="text" placeholder="Enter street"
															id="txtStreet" class="form-control"> <input
															type="text" id="txtStreet1" class="form-control">
														<div class="row">
															<div class="col-xs-4">
																<input type="text" placeholder="City"
																	class="form-control">
															</div>
															<div class="col-xs-4">
																<input type="text" placeholder="State"
																	class="form-control">
															</div>
															<div class="col-xs-4">
																<input type="text" placeholder="ZIP"
																	class="form-control">
															</div>
														</div>
														<input type="text" id="txtCountry" placeholder="Country"
															class="form-control">
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<!-- START CUSTOM TABS -->
												<!-- Custom Tabs -->
												<div class="nav-tabs-custom">
													<ul class="nav nav-tabs">
														<li class="active"><a href="#tab_1" data-toggle="tab">Internal
																Notes</a></li>
														<li><a href="#tab_2" data-toggle="tab">Sales &
																Purchases</a></li>

													</ul>
													<div class="tab-content">
														<div class="tab-pane active" id="tab_1">
															<textarea class="form-control" rows="6"
																placeholder="Put an internal note..."></textarea>
														</div>
														<!-- /.tab-pane -->
														<div class="tab-pane" id="tab_2">
															<div class="row">
																<div class="col-xs-6">
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-3 control-label">Internal
																			Reference</label>
																		<div class="col-sm-9">
																			<input type="text" placeholder="Internal Reference"
																				id="txtInternalReference" class="form-control">
																		</div>
																	</div>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-3 control-label">Language</label>
																		<div class="col-sm-9">
																			<input type="text" placeholder="Language"
																				id="txtLanguage" class="form-control">
																		</div>
																	</div>
																</div>
																<div class="col-xs-6">
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-3 control-label">Active</label>
																		<div class="col-sm-9">
																			<div class="checkbox">
																				<label> <input type="checkbox">
																				</label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-xs-6">
																	<h2 class="page-header">Sale</h2>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-3 control-label">Is
																			a Customer</label>
																		<div class="col-sm-9">
																			<div class="checkbox">
																				<label> <input type="checkbox">
																				</label>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-3 control-label">Sale
																			Person</label>
																		<div class="col-sm-9">
																			<input type="text" placeholder="Sale Person"
																				id="txtSalePerson" class="form-control">
																		</div>
																	</div>
																</div>
																<div class="col-xs-6">
																	<h2 class="page-header">Purchase</h2>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-3 control-label">Is
																			a Supplier</label>
																		<div class="col-sm-9">
																			<div class="checkbox">
																				<label> <input type="checkbox">
																				</label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-xs-6">
																	<h2 class="page-header">Mailing</h2>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-6 control-label">Receive
																			Inbox Notifications by Email</label>
																		<div class="col-sm-6">
																			<div class="radio">
																				<label> <input name="Notifications"
																					value="1" type="radio"> Never
																				</label>
																			</div>
																			<div class="radio">
																				<label> <input name="Notifications"
																					value="2" type="radio"> All Messages
																				</label>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-6 control-label">Opt-Out</label>
																		<div class="col-sm-6">
																			<div class="checkbox">
																				<label> <input type="checkbox">
																				</label>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="col-xs-6">
																	<h2 class="page-header">WareHouse</h2>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-4 control-label">Customer
																			Location</label>
																		<div class="col-sm-8">
																			<input type="text" placeholder="Customer Location"
																				id="txtCustomerLocation" class="form-control">
																		</div>
																	</div>
																	<div class="form-group">
																		<label for="InputTitle" class="col-sm-4 control-label">Supplier
																			Location</label>
																		<div class="col-sm-8">
																			<input type="text" placeholder="Supplier Location"
																				id="txtSupplierLocation" class="form-control">
																		</div>
																	</div>
																</div>
															</div>

														</div>
														<!-- /.tab-pane -->
													</div>
													<!-- /.tab-content -->
												</div>
												<!-- nav-tabs-custom -->
												<!-- END CUSTOM TABS -->
											</div>
										</div>

									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button class="btn btn-primary">Save</button>
										<button class="btn btn-default">Cancel</button>
									</div>
								</form>
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
	<script src="${URL}bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

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

		});
	</script>

</body>
</html>