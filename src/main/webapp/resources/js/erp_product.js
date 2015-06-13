$(function() {
	loadListProduct();

	loadPopupCreate();

	loadListSupplierProduct();
});

/**
 * Datatable load Product List
 */
function loadListProduct() {
	$("#dt_lstProduct")
			.dataTable(
					{
						"bProcessing" : false,
						"bServerSide" : false,
						"sort" : "position",
						"sAjaxSource" : "../product/searchListProduct.do",
						"aoColumns" : [ {
							"mData" : "name"
						}, {
							"mData" : "active"
						}, {
							"mData" : "salePrice"
						}, {
							"mData" : "costPrice"
						}, {
							"mData" : "id"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<button class="btn btn-default btn-xs" id="editCompany" onClick="clickEdit(\''
										+ data
										+ '\')"><i class="fa fa-edit"></i></button> - '
										+ '<button class="btn btn-primary btn-xs" id="viewCompany" onClick="clickView(\''
										+ data
										+ '\')"><i class="fa fa-info"></i></button> - '
										+ '<button class="btn btn-danger btn-xs" id="viewCompany" onClick="clickDelete(\''
										+ data
										+ '\')"><i class="fa fa-remove"></i></button>';
							},
							"targets" : 4
						} ],
						fnDrawCallback : function(oSettings) {
							$('div.dataTables_filter input').addClass(
									"form-control input-sm");
							$('div.dataTables_length select').addClass(
									"form-control input-sm");
						}
					});
}

function loadListSupplierProduct() {
	$("#dt_lstSupplier").dataTable();
}

/**
 * load popup create form
 */

function loadPopupCreate() {
	var popup = $('#erpModalPopup');

	$('#erpModalPopupButton').on('click', function() {
		$.ajax({
			url : './create.do',
			type : 'GET',
			cache : false,
			data : '',
			success : function(string) {
				$('#erpModalPopup').html(string);
				popup.modal('show');
			},
			error : function() {
				alert('Có lỗi xảy ra');
			}
		});
	});
}

/**
 * valid Form
 */

function validForm() {
	$('#formProduct').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			txtName : {
				message : 'The Name is not valid',
				validators : {
					notEmpty : {
						message : 'The name is required and can\'t be empty'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		// Prevent form submission
		e.preventDefault();
		// Get the form instance
		var $form = $(e.target);
		// Get the BootstrapValidator instance
		var bv = $form.data('bootstrapValidator');
		// Use Ajax to submit form data
		$.post($form.attr('action'), $form.serialize(), function(result) {
			if (!result.status) {
				alert(result.msg);
			}
			$('#erpModalPopup').modal('hide');
			$('#dt_lstProduct').dataTable().fnDestroy();
			loadListProduct();

		}, 'json');
	});
}

function clickView(id) {
	var popup = $('#erpModalPopup');
	$.ajax({
		url : './viewProduct.do/' + id,
		type : 'GET',
		cache : false,
		data : '',
		success : function(string) {
			$('#erpModalPopup').html(string);
			popup.modal('show');
		},
		error : function() {
			alert('Có lỗi xảy ra');
		}
	});

}

function clickEdit(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './editProduct.do/' + id,
		type : 'GET',
		cache : false,
		data : '',
		success : function(string) {
			$('#erpModalPopup').html(string);
			popup.modal('show');
		},
		error : function() {
			alert('Có lỗi xảy ra');
		}
	});

}

function clickDelete(id) {

	$.ajax({
		url : './deleteProduct.do',
		type : 'GET',
		cache : false,
		data : 'id=' + id,
		success : function(string) {
			var json = JSON.parse(JSON.stringify(string));
			if (!json.status) {
				alert(json.msg);
			}
			$('#dt_lstProduct').dataTable().fnDestroy();
			loadListProduct();
		}
	});

}