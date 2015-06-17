$(function() {
	loadListUser();

	loadPopupCreate();
	
});

/**
 * Datatable load User List
 */
function loadListUser() {
	$("#dt_lstUser")
			.dataTable(
					{
						"bProcessing" : false,
						"bServerSide" : false,
						"sort" : "position",
						"sAjaxSource" : "../user/searchListUser.do",
						"aoColumns" : [ {
							"mData" : "username"
						}, {
							"mData" : "email"
						}, {
							"mData" : "create_date"
						}, {
							"mData" : "login_date"
						}, {
							"mData" : "active"
						}, {
							"mData" : "user_type"
						}, {
							"mData" : "id"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<button id="editUser" onClick="clickEdit(\''
										+ data
										+ '\')">Edit</button> - '
										+ '<button id="viewUser" onClick="clickView(\''
										+ data
										+ '\')">View</button> - '
										+ '<button id="viewUser" onClick="clickDelete(\''
										+ data + '\')">Del</button>';
							},
							"targets" : 6
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

function validFormUser() {
	$('#formUser')
			.bootstrapValidator(
					{
						message : 'This value is not valid',
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							username : {
								message : 'The User Name is not valid',
								validators : {
									notEmpty : {
										message : 'The User Name is required and can\'t be empty'
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
							password : {
								validators : {
									notEmpty : {
										message : 'The password is required and can\'t be empty'
									}
								}
							},
							user_type : {
								validators : {
									notEmpty : {
										message : 'The user type is required and can\'t be empty'
									}
								}
							},
							create_date : {
								validators : {
									notEmpty : {
										message : 'The create date is required and can\'t be empty'
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
						$.post($form.attr('action'), $form.serialize(),
								function(result) {
									if (!result.status) {
										$('#alert').show();
										$('#message-error-exist-user').html(result.msg);
									} else {
										$('#erpModalPopup').modal('hide');
										$('#dt_lstUser').dataTable()
												.fnDestroy();
										loadListUser();
									}
								}, 'json');
					});
}

function clickView(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './viewUser.do/' + id,
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
		url : './editUser.do/' + id,
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
		url : './deleteUser.do',
		type : 'GET',
		cache : false,
		data : 'id=' + id,
		success : function(string) {
			var json = JSON.parse(JSON.stringify(string));
			if (!json.status) {
				alert(json.msg);
			}
			$('#dt_lstUser').dataTable().fnDestroy();
			loadListUser();
		}
	});

}

function clickCheckBoxAutoCreatePassword() {
	$('#ckbIsAutoCreate').change(function() {
		if ($(this).is(":checked")) {
			$('#txtPassword').text="";
			$('#txtPassword').prop("disabled", true);
			
		} else {
			$('#txtPassword').prop("disabled", false);
		}
	});
}