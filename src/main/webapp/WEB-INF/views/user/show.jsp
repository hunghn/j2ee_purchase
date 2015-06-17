<%@page import="j2ee.purchase.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%
	User user = (User) request.getAttribute("USER");
%>
<div class="modal-dialog">
	<div class="modal-content">
		<!-- form start -->
		<form role="form" class="form-horizontal" action="./submitUser.do"
			id="formViewUser" method="POST">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="erpModalPopupLabel">${PAGE_NAME}</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">

						<div class="box-body">
							<div class="row">

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">User
										Name</label>
									<div class="col-md-6">
										<input type="text" class="form-control" name="username"
											id="txtUserName" disabled="disabled" value="${USER.username}"
											placeholder="User Name">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Email</label>
									<div class="col-md-6">
										<input type="email" class="form-control" id="txtEmail"
											name="email" disabled="disabled" value="${USER.email}"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">Create
										date</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtCreateDate"
											name="create_date" disabled="disabled"
											value="${USER.create_date}" placeholder="Create date">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">Login
										date</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtLoginDate"
											name="Login_date" disabled="disabled"
											value="${USER.login_date}" placeholder="Login date">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">User
										Type</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtUserType"
											name="user_type" disabled="disabled"
											value="${USER.user_type}" placeholder="User Type">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Active
									</label>
									<div class="checkbox">
										<input class="col-md-2 control-label" type="checkbox"
											id="ckbActive" name="active" disabled="disabled"
											<%if (user.getActive()) {%> checked="checked" <%}%>>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->

					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</form>
	</div>
</div>