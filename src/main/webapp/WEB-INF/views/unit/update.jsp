<%@page import="j2ee.purchase.model.Unit"%>
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
	Unit unit = (Unit) request.getAttribute("UNIT");
%>Unitss="modal-dialog">
	<div class="modal-content">
		<!-- form start -->
		<form role="form" class="form-horizontal"
			action="./submitUnit.do" id="formUnit" method="POST">
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
									<div id="message-error-exist-unit"></div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Name</label>
									<div class="col-md-6">
										<input type="text" class="form-control" name="name"
											id="txtName" value="${UNIT.name}" placeholder="Name"
											readonly="readonly">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputPhone">Rouding</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtRouding"
											name="rouding" value="${UNIT.rouding}"
											placeholder="Rouding">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Active
									</label>
									<div class="checkbox">
										<input class="col-md-2 control-label" type="checkbox"
											id="ckbActive" name="active"
											<%if (unit.getActive()) {%> checked="checked" <%}%>>
									</div>
								</div>
								<div class="form-group">
							</div>
						</div>
						<!-- /.box-body -->

					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input type="hidden" value="true" name="isUpdate" /> <input
					type="hidden" value="${UNIT.id}" name="uuid" />
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		validFormUnit();
	});
</script>