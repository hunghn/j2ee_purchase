<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE 2 | Create Supplier</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="../dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins
        folder instead of downloading all of them to reduce the load. -->
<link href="../dist/css/skins/_all-skins.min.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
            <![endif]-->
</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">

			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>ERP</b>A</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>ERP</b>Admin</span>
			</a>

			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i>
						</a></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i>
						</a></li>
						<!-- Tasks: style can be found in dropdown.less -->
						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-flag-o"></i>
						</a></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image" /> <span class="hidden-xs">Trungpv</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image" />
									<p>
										Trungpv - Administrator <small>Member since Nov. 2012</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>

			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MAIN MENU</li>
					<li><a href="index.html"> <i class="fa fa-dashboard"></i>
							<span>Dashboard</span>
					</a></li>

					<li class="treeview"><a href="#"> <i
							class="fa fa-buysellads"></i> <span>Purchase</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Requests for Quotation</a></li>
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Purchase Orders</a></li>
							<li><a href="#"><i class="fa fa-dot-circle-o"></i> Call
									for Tenders</a></li>
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Suppliers</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-list"></i>
							<span>Incoming Products</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Incoming Products</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-fax"></i>
							<span>Invoice Control</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-dot-circle-o"></i> On
									Draft Invoices</a></li>
							<li><a href="#"><i class="fa fa-dot-circle-o"></i> On
									Purchase Order Lines</a></li>
							<li><a href="#"><i class="fa fa-dot-circle-o"></i> On
									Incoming Shipments</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-archive"></i>
							<span>Products</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Products</a></li>
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Products by Category</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-gear"></i>
							<span>Configuration</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-dot-circle-o"></i>
									Products</a></li>
						</ul></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

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
														<input type="text" placholder="Phone" id="txtPhone"
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

		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>ERP</b> Admin
			</div>
			<strong>Copyright &copy; 2015-2016. All rights reserved. 
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.3 -->
	<script src="../plugins/jQuery/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

	<!-- SlimScroll -->
	<script src="../plugins/slimScroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script src='../plugins/fastclick/fastclick.min.js'></script>
	<!-- AdminLTE App -->
	<script src="../dist/js/app.min.js" type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
		$(function() {

		});
	</script>

</body>
</html>