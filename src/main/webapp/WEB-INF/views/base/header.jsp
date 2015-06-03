<%@page import="java.text.SimpleDateFormat"%>
<%@page import="j2ee.purchase.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="main-header">

	<!-- Logo -->
	<a href="${BASE_URL}home.do" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
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
				<%
					User user = (User)session.getAttribute("USERLOGIN");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				%>
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${URL}dist/img/avatar5.png" class="user-image"
						alt="User Image" /> <span class="hidden-xs"><%=user.getUsername() %></span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="${URL}dist/img/avatar5.png" class="img-circle"
							alt="User Image" />
							<p>
								<%=user.getUsername() %> - Administrator <small>Member since <%=sdf.format(user.getCreate_date()) %></small>
							</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="${BASE_URL}logout.do" class="btn btn-default btn-flat">Sign out</a>
							</div>
						</li>
					</ul></li>
			</ul>
		</div>
	</nav>
</header>