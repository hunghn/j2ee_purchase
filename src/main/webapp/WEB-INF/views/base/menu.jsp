<%@page import="j2ee.purchase.utils.Menu.MENU_ITEM"%>
<%@page import="j2ee.purchase.utils.Menu.MENU"%>
<%@page import="j2ee.purchase.utils.Menu"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Menu menu = (Menu) request.getAttribute("MENU");
%>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN MENU</li>
			<li <%if (menu.getMenu() == MENU.DRASHBOAD) {%> class="active" <%}%>><a
				href="${BASE_URL}home.do"> <i class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>

			<li
				class="treeview <%if (menu.getMenu() == MENU.PURCHASE) {%>active<%}%>"><a
				href="#"> <i class="fa fa-buysellads"></i> <span>Purchase</span>
					<i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.PURCHASE_REQUEST_FOR_QUOTATION) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> Requests for Quotation</a></li>
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.PURCHASE_PURCHASE_ORDERS) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> Purchase Orders</a></li>
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.PURCHASE_CALL_FOR_TENDERS) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> Call for Tenders</a></li>
					<li <%if (menu.getMenu_item() == MENU_ITEM.PURCHASE_SUPPLIERS) {%>
						class="active" <%}%>><a href="${BASE_URL}supplier/list.do"><i
							class="fa fa-dot-circle-o"></i> Suppliers</a></li>
				</ul></li>

			<li
				class="treeview <%if (menu.getMenu() == MENU.INCOMING_PRODUCTS) {%>active<%}%>"><a
				href="#"> <i class="fa fa-list"></i> <span>Incoming
						Products</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.INCOMING_PRODUCTS_INCOMING_PRODUCTS) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> Incoming Products</a></li>
				</ul></li>

			<li
				class="treeview <%if (menu.getMenu() == MENU.INVOICE_CONTROL) {%>active<%}%>"><a
				href="#"> <i class="fa fa-fax"></i> <span>Invoice Control</span>
					<i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.INVOICE_CONTROL_ON_DRAFT_INVOICES) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> On Draft Invoices</a></li>
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.INVOICE_CONTROL_ON_PURCHASE_ORDER_LINES) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> On Purchase Order Lines</a></li>
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.INVOICE_CONTROL_ON_INCOMING_SHIPMENTS) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> On Incoming Shipments</a></li>
				</ul></li>

			<li
				class="treeview <%if (menu.getMenu() == MENU.PRODUCTS) {%>active<%}%>"><a
				href="#"> <i class="fa fa-archive"></i> <span>Products</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li <%if (menu.getMenu_item() == MENU_ITEM.PRODUCTS_PRODUCTS) {%>
						class="active" <%}%>><a href="${BASE_URL}product/list.do"><i
							class="fa fa-dot-circle-o"></i> Products</a></li>
					<li
						<%if (menu.getMenu_item() == MENU_ITEM.PRODUCTS_PRODUCTS_BY_CATEGORY) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> Products by Category</a></li>
				</ul></li>

			<li
				class="treeview <%if (menu.getMenu() == MENU.CONFIG) {%>active<%}%>"><a
				href="#"> <i class="fa fa-gear"></i> <span>Configuration</span>
					<i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li <%if (menu.getMenu_item() == MENU_ITEM.CONFIG_PRODUCTS) {%>
						class="active" <%}%>><a href="${BASE_URL}#"><i
							class="fa fa-dot-circle-o"></i> Products</a></li>
				</ul></li>

			<li
				class="treeview <%if (menu.getMenu() == MENU.MANAGER) {%>active<%}%>"><a
				href="#"> <i class="fa fa-reorder"></i> <span>Manager</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li <%if (menu.getMenu_item() == MENU_ITEM.MANAGER_COMPANIES) {%>
						class="active" <%}%>><a href="${BASE_URL}company/list.do"><i
							class="fa fa-dot-circle-o"></i> Company</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>