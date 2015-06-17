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
			id="formUser" method="POST">
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

								<div class="alert alert-danger alert-dismissable" id="alert"
									style="display: none;">
									<button aria-hidden="true" data-dismiss="alert" class="close"
										type="button">×</button>
									<h4>
										<i class="icon fa fa-ban"></i> Alert!
									</h4>
									<div id="message-error-exist-user"></div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">User
										Name</label>
									<div class="col-md-6">
										<input type="text" class="form-control" name="username"
											id="txtUserName" value="${USER.username}"
											placeholder="User Name" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Email</label>
									<div class="col-md-6">
										<input type="email" class="form-control" id="txtEmail"
											name="email" value="${USER.email}" placeholder="Email"
											readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">Create
										date</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtCreateDate"
											name="create_date" value="${USER.create_date}"
											placeholder="01/01/2015" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">Login
										date</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtLoginDate"
											name="login_date" value="${USER.login_date}"
											placeholder="01/01/2015" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">User
										type</label>
									<div class="col-md-6">
										<select class="selectpicker" id="selUserType">
											<option>1</option>
											<option>2</option>
											<option>3</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Active
									</label>
									<div class="checkbox">
										<input class="col-md-2 control-label" type="checkbox"
											id="ckbActive" name="active" <%if (user.getActive()) {%>
											checked="checked" <%}%>>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->

					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input type="hidden" value="true" name="isUpdate" /> <input
					type="hidden" value="${USER.id}" name="uuid" />
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		validFormUser();
	});
</script>