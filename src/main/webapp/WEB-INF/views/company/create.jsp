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
<div class="modal-dialog">
	<div class="modal-content">
		<!-- form start -->
		<form role="form" class="form-horizontal"
			action="./submitCompany.do" id="formCompany" method="POST">
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
									<label class="col-md-3 control-label" for="InputEmail">Name</label>
									<div class="col-md-6">
										<input type="text" class="form-control" name="name"
											id="txtName" placeholder="Name">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputPhone">Phone</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtPhone"
											name="phone" placeholder="Phone">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Email</label>
									<div class="col-md-6">
										<input type="email" class="form-control" id="txtEmail"
											name="email" placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputAddress">Address</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtAddress"
											name="address" placeholder="Address">
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
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		validForm();
	});
</script>