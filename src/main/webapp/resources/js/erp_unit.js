$(function() {
	loadListUnit();

	loadPopupCreate();
});

/**
 * Datatable load Unit List
 */
function loadListUnit() {
	$("#dt_lstUnit")
			.dataTable(
					{
						"bProcessing" : false,
						"bServerSide" : false,
						"sort" : "position",
						"sAjaxSource" : "../unit/searchListUnit.do",
						"aoColumns" : [ {
							"mData" : "name"
						}, {
							"mData" : "rouding"
						}, {
							"mData" : "active"
						}, {
							"mData" : "id"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<button id="editUnit" onClick="clickEdit(\''
										+ data
										+ '\')">Edit</button> - '
										+ '<button id="viewUnit" onClick="clickView(\''
										+ data
										+ '\')">View</button> - '
										+ '<button id="viewUnit" onClick="clickDelete(\''
										+ data + '\')">Del</button>';
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

function validFormUnit() {
	$('#formUnit').bootstrapValidator({
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
			rouding : {
				validators : {
					notEmpty : {
						message : 'The rouding is required and can\'t be empty'
					},
					regexp : {
						regexp : /\d$/,
						message : 'The rouding incorrect format.'
					},
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
				$('#alert').show();
				$('#message-error-exist-unit').html(result.msg);
			} else {
				$('#erpModalPopup').modal('hide');
				$('#dt_lstUnit').dataTable().fnDestroy();
				loadListUnit();
			}

		}, 'json');
	});
}

function clickView(id) {

	var popup = $('#erpModalPopup');
	$.ajax({
		url : './viewUnit.do/' + id,
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
		url : './editUnit.do/' + id,
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
		url : './deleteUnit.do',
		type : 'GET',
		cache : false,
		data : 'id=' + id,
		success : function(string) {
			var json = JSON.parse(JSON.stringify(string));
			if (!json.status) {
				alert(json.msg);
			}
			$('#dt_lstUnit').dataTable().fnDestroy();
			loadListUnit();
		}
	});

}