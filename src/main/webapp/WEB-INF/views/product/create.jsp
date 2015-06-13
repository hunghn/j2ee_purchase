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
<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<!-- form start -->
		<form role="form" class="form-horizontal" action="./submitProduct.do"
			id="formProduct" method="POST">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="erpModalPopupLabel">${PAGE_NAME}</h4>
			</div>
			<div class="modal-body">
				<!-- Body -->
				<div class="box-body">
					<div class="row">
						<div class="box box-primary">
							<div class="row margin">
								<div class="col-xs-6">
									<div class="col-xs-4">
										<img width="100" src="../resources/dist/img/boxed-bg.jpg"
											class="img-circle" alt="User Image">
									</div>
									<div class="col-xs-6">
										<div class="form-group">
											<label>Product Name</label> <input type="text"
												class="form-control" name="txtName"
												placeholder="Product Name">
										</div>
									</div>
								</div>
								<div class="col-xs-6">


									<a class="btn btn-app"> <i class="fa fa-edit"></i> Purchase
									</a> <a class="btn btn-app"> <i class="fa fa-edit"></i> On Hand
									</a> <a class="btn btn-app"> <i class="fa fa-edit"></i> Moves
									</a> <a class="btn btn-app"> <i class="fa fa-edit"></i>
										Reordering Rule
									</a> <a class="btn btn-app"> <i class="fa fa-edit"></i> Routes
									</a>
								</div>
							</div>
						</div>

					</div>
					<div class="row">
						<div class="nav-tabs-custom">
							<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
								<li class="active"><a href="#information" data-toggle="tab">Information</a></li>
								<li><a href="#procurements" data-toggle="tab">Procurements</a></li>
								<li><a href="#inventory" data-toggle="tab">Inventory</a></li>
								<li><a href="#sales" data-toggle="tab">Sales</a></li>
								<li><a href="#accounting" data-toggle="tab">Accounting</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active margin" id="information">
									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-3 control-label">Sale Price</label>
												<div class="col-sm-7">
													<input type="text" name="txtSalePrice" class="form-control"
														placeholder="Sale Price">
												</div>
												<!-- /.input group -->
											</div>
										</div>
										<div class="col-xs-6">
											<div class="form-group">
												<label for="InputTitle" class="col-sm-4 control-label">Active</label>
												<div class="col-sm-8">
													<div class="checkbox">
														<label> <input type="checkbox" checked="checked"
															name="txtActive">
														</label>
													</div>
												</div>
											</div>
											<!-- <div class="form-group">
												<label class="col-sm-4 control-label">Internal
													Reference</label>
												<div class="col-sm-7">
													<input type="text" name="txtInternalReference"
														class="form-control" placeholder="Internal Reference">
												</div>										
											</div>-->


										</div>
									</div>
									<div class="row">
										<div class="box-body pad">
											<textarea class="textarea" name="txtDescription"
												placeholder="describe the product characteristics..."
												style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
										</div>
									</div>
								</div>
								<div class="tab-pane margin" id="procurements">
									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label">Cost Price</label>
												<div class="col-sm-7">
													<input type="text" name="txtCostPrice" class="form-control"
														placeholder="Cost Price">
												</div>
												<!-- /.input group -->
											</div>
										</div>
									</div>
									<h2 class="page-header">Supplier</h2>
									<div class="row">
										<table id="dt_lstSupplier"
											class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>Supplier</th>
													<th>Delivery Lead Time</th>
													<th>Minimal Quantity</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
								<div class="tab-pane margin" id="inventory">
									<h3>Update</h3>
								</div>
								<div class="tab-pane margin" id="sales">

									<div class="row margin">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-5 control-label">Warranty</label>
												<div class="col-sm-7">
													<input type="text" name="txtWarranty" class="form-control"
														placeholder="Warranty">
												</div>
												<!-- /.input group -->
											</div>

											<div class="form-group">
												<label class="col-sm-5 control-label">Customer Lead
													Time</label>
												<div class="col-sm-7">
													<input type="text" name="txtCustomerLeadTime"
														class="form-control" placeholder="Customer Lead Time">
												</div>
												<!-- /.input group -->
											</div>
										</div>

									</div>
									<div class="row">
										<h3>Description for Quotations</h3>
									</div>
									<div class="row">
										<div class="box-body pad">
											<textarea class="textarea" name="txtNote"
												placeholder="note to be displayed on quotations..."
												style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
										</div>
									</div>
								</div>
								<div class="tab-pane margin" id="accounting">
									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-5 control-label">Customer Taxes</label>
												<div class="col-sm-7">
													<select name="txtCustomerTaxes" class="form-control">
														<option value="-1" selected="selected"></option>
														<c:forEach var="accounttax" items="${LIST_ACCOUNTTAX}">
															<option value="${accounttax.id}">${accounttax.name}</option>
														</c:forEach>
													</select>
												</div>
												<!-- /.input group -->
											</div>

											<div class="form-group">
												<label class="col-sm-5 control-label">Supplier Taxes</label>
												<div class="col-sm-7">
													<select name="txtSupplierTaxes" class="form-control">
														<option value="-1" selected="selected"></option>
														<c:forEach var="accounttax" items="${LIST_ACCOUNTTAX}">
															<option value="${accounttax.id}">${accounttax.name}</option>
														</c:forEach>
													</select>
												</div>
												<!-- /.input group -->
											</div>
										</div>
										<div class="col-xs-6"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- //. Body -->
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