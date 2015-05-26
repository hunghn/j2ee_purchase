<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:choose>
	<c:when test="${empty sessionScope['USERLOGIN']}">
	</c:when>
	<c:otherwise>
		<c:redirect url="/home.do" />
	</c:otherwise>
</c:choose>
<%@ include file="./base/head.jsp"%>

<!-- iCheck -->
<link href="${URL}plugins/iCheck/square/blue.css" rel="stylesheet"
	type="text/css" />
</head>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="./"><b>ERP </b>Admin</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<!--                <div class="social-auth-links text-center">
                    <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a>
                    <a href="#" class="btn btn-block btn-social btn-google-plus btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>
                </div> /.social-auth-links 
                <p class="text-center">- OR -</p>-->
			<%
				String msg = (String) request.getAttribute("MSG");
				if (msg != null) {
			%>
			<div class="alert alert-danger alert-dismissable">
				<button aria-hidden="true" data-dismiss="alert" class="close"
					type="button">×</button>
				<h4>
					<i class="icon fa fa-ban"></i> Alert!
				</h4>
				<%=msg%>
			</div>
			<%
				}
			%>
			<form action="login.do" method="post">
				<input type="hidden" name="token" id="token" value="${TOKEN}" />
				<div class="form-group has-feedback">
					<input type="email" name="email" class="form-control"
						placeholder="Email" /> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="Password" /> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> Remember Me
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<!--                <a href="#">I forgot my password</a><br>
                                <a href="register.html" class="text-center">Register a new membership</a>-->

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.1.3 -->
	<script src="${URL}plugins/jQuery/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="${URL}bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script src="${URL}plugins/iCheck/icheck.min.js" type="text/javascript"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>