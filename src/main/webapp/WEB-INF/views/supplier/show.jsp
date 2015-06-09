<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="j2ee.purchase.model.Company"%>
<%@page import="java.util.List"%>
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
		<form role="form" class="form-horizontal" action="" id="formSupplier"
			method="POST">
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
								<div class="col-xs-6">
									<div class="form-group">
										<label for="InputName" class="col-sm-3 control-label">Name</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Enter name" id="txtName"
												name="txtName" value="${SUPPLIER.name}" disabled="disabled"
												class="form-control">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<label for="InputCompany" class="col-sm-3 control-label">Company</label>
										<div class="col-sm-9">
											<select name="txtCompany" disabled="disabled"
												class="combobox form-control" id="txtCompany">
												<c:choose>
													<c:when test="${SUPPLIER.company.id}">
														<option value="-1" selected="selected"></option>
													</c:when>
													<c:otherwise>
														<option value="-1"></option>
													</c:otherwise>
												</c:choose>
												<c:forEach var="company" items="${LIST_COMPANY}">
													<c:choose>
														<c:when test="${SUPPLIER.company.id==company.id}">
															<option selected="selected" value="${company.id}">${company.name}</option>
														</c:when>
														<c:otherwise>
															<option value="${company.id}">${company.name}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">

									<div class="form-group">
										<label for="InputEmail" class="col-sm-3 control-label">Email</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Email" id="txtEmail"
												name="txtEmail" value="${SUPPLIER.email}"
												disabled="disabled" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label for="InputPhone" class="col-sm-3 control-label">Phone</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Phone" id="txtPhone"
												name="txtPhone" value="${SUPPLIER.phone}"
												disabled="disabled" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label for="InputMobile" class="col-sm-3 control-label">Mobile</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Mobile" id="txtMobile"
												name="txtMobile" value="${SUPPLIER.mobile}"
												disabled="disabled"
												class="form-control
                                                                   ">
										</div>
									</div>
									<div class="form-group">
										<label for="InputFax" class="col-sm-3 control-label">Fax</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Fax" id="txtFax"
												name="txtFax" value="${SUPPLIER.fax}" disabled="disabled"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label for="InputWebsite" class="col-sm-3 control-label">Website</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Website" id="txtWebsite"
												name="txtWebsite" value="${SUPPLIER.website}"
												disabled="disabled" class="form-control">
										</div>
									</div>
								</div>
								<div class="col-xs-6">

									<!-- <div class="form-group">
										<label for="InputJobPosition" class="col-sm-3 control-label">Job
											Position</label>
										<div class="col-sm-9">
											<input type="text" placeholder="e.g. Sales Director"
												id="txtJobPosition" class="form-control">
										</div>
									</div> -->
									<div class="form-group" id="isUseCompanyAddress">
										<label for="InputTitle" class="col-sm-3 control-label">

										</label>
										<div class="col-sm-9">
											<div class="checkbox">
												<label> <input type="checkbox"
													name="txtUseCompanyAddress" id="txtUseCompanyAddress">Use
													Company Address
												</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="InputAddress" class="col-sm-3 control-label">Address</label>
										<div class="col-sm-9">
											<input type="text" placeholder="Enter street" id="txtStreet"
												name="txtStreet" value="${SUPPLIER.street}"
												disabled="disabled" class="form-control">
											<div class="row">
												<div class="col-xs-4">
													<input type="text" placeholder="City" id="txtCity"
														name="txtCity" value="${SUPPLIER.city}"
														disabled="disabled" class="form-control">
												</div>
												<div class="col-xs-4">
													<input type="text" placeholder="State" id="txtState"
														name="txtState" value="${SUPPLIER.state}"
														disabled="disabled" class="form-control">
												</div>
												<div class="col-xs-4">
													<input type="text" placeholder="ZIP" id="txtZipCode"
														name="txtZipCode" value="${SUPPLIER.zipcode}"
														disabled="disabled" class="form-control">
												</div>
											</div>
											<input type="text" id="txtCountry" name="txtCountry"
												placeholder="Country" value="${SUPPLIER.country}"
												disabled="disabled" class="form-control">
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
												<textarea class="form-control" rows="6" disabled="disabled"
													name="txtComment" placeholder="Put an internal note...">${SUPPLIER.comment_text}</textarea>
											</div>
											<!-- /.tab-pane -->
											<div class="tab-pane" id="tab_2">
												<div class="row">
													<div class="col-xs-6">
														<div class="form-group">
															<label for="InputTitle" class="col-sm-3 control-label">Active</label>
															<div class="col-sm-9">
																<div class="checkbox">
																	<label> <c:choose>
																			<c:when test="${SUPPLIER.active}">
																				<input type="checkbox" disabled="disabled"
																					checked="checked" name="txtActive">
																			</c:when>
																			<c:otherwise>
																				<input type="checkbox" disabled="disabled"
																					name="txtActive">
																			</c:otherwise>
																		</c:choose>
																	</label>
																</div>
															</div>
														</div>
													</div>
													<div class="col-xs-6">
														<!-- <div class="form-group">
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
														</div> -->
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
																	<label> <c:choose>
																			<c:when test="${SUPPLIER.is_customer}">
																				<input type="checkbox" disabled="disabled"
																					checked="checked" name="txtIsCustomer">
																			</c:when>
																			<c:otherwise>
																				<input type="checkbox" disabled="disabled"
																					name="txtIsCustomer">
																			</c:otherwise>
																		</c:choose>
																	</label>
																</div>
															</div>
														</div>
														<div class="form-group">
															<label for="InputTitle" class="col-sm-3 control-label">Sale
																Person</label>
															<div class="col-sm-9">
																<select name="txtSalePerson" disabled="disabled"
																	class="combobox form-control" name="txtSalePerson">
																	<c:choose>
																		<c:when test="${SUPPLIER.user.id}">
																			<option value="-1" selected="selected"></option>
																		</c:when>
																		<c:otherwise>
																			<option value="-1"></option>
																		</c:otherwise>
																	</c:choose>
																	<c:forEach var="user" items="${LIST_USER}">
																		<c:choose>
																			<c:when test="${SUPPLIER.user.id==user.id}">
																				<option selected="selected" value="${user.id}">${user.username}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${user.id}">${user.username}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</select>
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
																	<label> <c:choose>
																			<c:when test="${SUPPLIER.is_supplier}">
																				<input type="checkbox" disabled="disabled"
																					checked="checked" name="txtIsSupplier">
																			</c:when>
																			<c:otherwise>
																				<input type="checkbox" disabled="disabled"
																					name="txtIsSupplier">
																			</c:otherwise>
																		</c:choose>
																	</label>
																</div>
															</div>
														</div>
													</div>
												</div>
												<!-- <div class="row">
													<div class="col-xs-6">
														<h2 class="page-header">Mailing</h2>
														<div class="form-group">
															<label for="InputTitle" class="col-sm-6 control-label">Receive
																Inbox Notifications by Email</label>
															<div class="col-sm-6">
																<div class="radio">
																	<label> <input name="Notifications" value="1"
																		type="radio"> Never
																	</label>
																</div>
																<div class="radio">
																	<label> <input name="Notifications" value="2"
																		type="radio"> All Messages
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
												</div> -->

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

					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		//$('.combobox').combobox()

		//Hide Company
		$('#isUseCompanyAddress').hide();

		//even change company
		$('#txtCompany').on('change', function() {
			if (this.value == "-1") {
				$('#isUseCompanyAddress').hide();
			} else {
				$('#isUseCompanyAddress').show();
			}
		});

	});
	$(function() {
		validForm();
	});
</script>