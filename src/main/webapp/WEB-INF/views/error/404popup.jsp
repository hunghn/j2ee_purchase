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
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="erpModalPopupLabel">${PAGE_NAME}</h4>
		</div>
		<div class="modal-body">
			<!-- Main content -->
			<section class="content">
				<div class="error-page">
					<h2 class="headline text-yellow">404</h2>
					<div class="error-content">
						<h3>
							<i class="fa fa-warning text-yellow"></i> Oops! Không tìm thấy
							trang.
						</h3>
					</div>
					<!-- /.error-content -->
				</div>
				<!-- /.error-page -->
			</section>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		</div>
	</div>
</div>