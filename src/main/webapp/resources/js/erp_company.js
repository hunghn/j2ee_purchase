$(function() {
	loadListCompany();

	loadPopupCreate();
});

/**
 * Datatable load Company List
 */
function loadListCompany() {
	$("#dt_lstCompany")
			.dataTable(
					{
						"bProcessing" : false,
						"bServerSide" : false,
						"sort" : "position",
						"sAjaxSource" : "../company/searchListCompany.do",
						"aoColumns" : [ {
							"mData" : "name"
						}, {
							"mData" : "phone"
						}, {
							"mData" : "email"
						}, {
							"mData" : "address"
						}, {
							"mData" : "id"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<button id="editCompany" onClick="clickEdit(\''
										+ data
										+ '\')">Edit</button> - '
										+ '<button id="viewCompany" onClick="clickView(\''
										+ data
										+ '\')">View</button> - '
										+ '<button id="viewCompany" onClick="clickDelete(\''
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

function validForm() {
	$('#formCompany')
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
							email : {
								validators : {
									notEmpty : {
										message : 'The email address is required and can\'t be empty'
									},
									emailAddress : {
										message : 'The input is not a valid email address'
									}
								}
							},
							phone : {
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
							address : {
								validators : {
									notEmpty : {
										message : 'The address is required and can\'t be empty'
									}
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
						$
								.post($form.attr('action'), $form.serialize(),
										function(result) {
											if (!result.status) {
												alert(result.msg);
											}
											$('#erpModalPopup').modal('hide');
											$('#dt_lstCompany').dataTable()
													.fnDestroy();
											loadListCompany();

										}, 'json');
					});
}

function clickView(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './viewCompany.do/' + id,
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

function clickView(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './editCompany.do/' + id,
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
		url : './editCompany.do/' + id,
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
		url : './deleteCompany.do',
		type : 'GET',
		cache : false,
		data : 'id=' + id,
		success : function(string) {
			var json = JSON.parse(JSON.stringify(string));
			if (!json.status) {
				alert(json.msg);
			}
			$('#dt_lstCompany').dataTable().fnDestroy();
			loadListCompany();
		}
	});

}