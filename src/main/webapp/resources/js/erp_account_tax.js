$(function() {
	loadListAccountTax();

	loadPopupCreate();
});

/**
 * Datatable load AccountTax List
 */
function loadListAccountTax() {
	$("#dt_lstAccountTax")
			.dataTable(
					{
						"bProcessing" : false,
						"bServerSide" : false,
						"sort" : "position",
						"sAjaxSource" : "../account-tax/searchListAccountTax.do",
						"aoColumns" : [ {
							"mData" : "name"
						}, {
							"mData" : "amount"
						}, {
							"mData" : "active"
						}, {
							"mData" : "description"
						}, {
							"mData" : "id"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<button id="editAccountTax" onClick="clickEdit(\''
										+ data
										+ '\')">Edit</button> - '
										+ '<button id="viewAccountTax" onClick="clickView(\''
										+ data
										+ '\')">View</button> - '
										+ '<button id="viewAccountTax" onClick="clickDelete(\''
										+ data + '\')">Del</button>';
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

function validFormAccountTax() {
	$('#formAccountTax')
			.bootstrapValidator(
					{
						message : 'This value is not valid',
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							name : {
								message : 'The Name is not valid',
								validators : {
									notEmpty : {
										message : 'The name is required and can\'t be empty'
									}
								}
							},
							amount : {
								validators : {
									notEmpty : {
										message : 'The amount is required and can\'t be empty'
									},
									regexp : {
										regexp : /\d$/,
										message : 'The amount incorrect format.'
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
										$('#alert').show();
										$('#message-error-exist-account-tax').html(result.msg);	
									}else{
										$('#erpModalPopup').modal('hide');
										$('#dt_lstAccountTax').dataTable()
												.fnDestroy();
										loadListAccountTax();
									}

								}, 'json');
					});
}

function clickView(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './viewAccountTax.do/' + id,
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
		url : './editAccountTax.do/' + id,
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
		url : './deleteAccountTax.do',
		type : 'GET',
		cache : false,
		data : 'id=' + id,
		success : function(string) {
			var json = JSON.parse(JSON.stringify(string));
			if (!json.status) {
				alert(json.msg);
			}
			$('#dt_lstAccountTax').dataTable().fnDestroy();
			loadListAccountTax();
		}
	});

}