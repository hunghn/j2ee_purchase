$(function() {
	loadListSupplier();

	loadPopupCreate();
});

/**
 * Datatable load Supplier List
 */
function loadListSupplier() {
	$("#dt_lstSupplier")
			.dataTable(
					{
						"bProcessing" : false,
						"bServerSide" : false,
						"sort" : "position",
						"sAjaxSource" : "../supplier/searchListSupplier.do",
						"aoColumns" : [ {
							"mData" : "name"
						}, {
							"mData" : "phone"
						}, {
							"mData" : "email"
						}, {
							"mData" : "id"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<button class="btn btn-default btn-xs" id="editSupplier" onClick="clickEdit(\''
										+ data
										+ '\')"><i class="fa fa-edit"></i></button> - '
										+ '<button class="btn btn-primary btn-xs" id="viewSupplier" onClick="clickView(\''
										+ data
										+ '\')"><i class="fa fa-info"></i></button> - '
										+ '<button class="btn btn-danger btn-xs" id="viewSupplier" onClick="clickDelete(\''
										+ data
										+ '\')"><i class="fa fa-remove"></i></button>';
							},
							"targets" : 3
						} ],
						fnDrawCallback : function(oSettings) {
							$('div.dataTables_filter input').addClass(
									"form-control input-sm");
							$('div.dataTables_length select').addClass(
									"form-control input-sm");
						}
					});

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
	$('#formSupplier')
			.bootstrapValidator(
					{
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
							},
							txtEmail : {
								validators : {
									notEmpty : {
										message : 'The email address is required and can\'t be empty'
									},
									emailAddress : {
										message : 'The input is not a valid email address'
									}
								}
							},
							txtPhone : {
								validators : {
									notEmpty : {
										message : 'The phone is required and can\'t be empty'
									},
									regexp : {
										regexp : /^(\+\d{2,4})?\s?(\d{10,11})$/,
										message : 'The phone incorrect format.'
									},
								}
							},
							txtMobile : {
								validators : {
									regexp : {
										regexp : /^(\+\d{2,4})?\s?(\d{10,11})$/,
										message : 'The mobile incorrect format.'
									},
								}
							},
							txtFax : {
								validators : {
									regexp : {
										regexp : /^(\+\d{2,4})?\s?(\d{10,11})$/,
										message : 'The fax incorrect format.'
									},
								}
							}
						}
					}).on(
					'success.form.bv',
					function(e) {
						// Prevent form submission
						e.preventDefault();
						// Get the form instance
						var $form = $(e.target);
						// Get the BootstrapValidator instance
						var bv = $form.data('bootstrapValidator');
						// Use Ajax to submit form data
						$.post($form.attr('action'), $form.serialize(),
								function(result) {
									if (!result.status) {
										alert(result.msg);
									}
									$('#erpModalPopup').modal('hide');
									$('#dt_lstSupplier').dataTable()
											.fnDestroy();
									loadListSupplier();

								}, 'json');
					});
}

function clickView(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './viewSupplier.do/' + id,
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
		url : './editSupplier.do/' + id,
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
		url : './deleteSupplier.do',
		type : 'GET',
		cache : false,
		data : 'id=' + id,
		success : function(string) {
			var json = JSON.parse(JSON.stringify(string));
			if (!json.status) {
				alert(json.msg);
			}
			$('#dt_lstSupplier').dataTable().fnDestroy();
			loadListSupplier();
		}
	});

}