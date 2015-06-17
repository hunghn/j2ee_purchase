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
	Unit unit = (Unit)request.getAttribute("UNIT");
%>
<div class="modal-dialog">
	<div class="modal-content">
		<!-- form start -->
		<form role="form" class="form-horizontal"
			action="./submitAccountTax.do" id="formViewUnit" method="POST">
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
											id="txtName" disabled="disabled" value="${UNIT.name}"
											placeholder="Name">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="InputPhone">Rouding</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="txtRouding"
											name="rouding" disabled="disabled"
											value="${UNIT.rouding}" placeholder="0.0">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="InputEmail">Active
									</label>
									<div class="checkbox">
										<input class="col-md-2 control-label" type="checkbox"
											id="ckbActive" name="active" disabled="disabled"
											<%if (unit.getActive()) {%> checked="checked" <%}%>">
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