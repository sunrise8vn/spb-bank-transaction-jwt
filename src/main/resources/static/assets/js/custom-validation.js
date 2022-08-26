
$(function () {
    page.dialogs.elements.frmCreateCustomer.validate({
        onkeyup: function(element) { $(element).valid() },
        onclick: false,
        onfocusout: false,
        rules: {
            fullName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            email: {
                required: true,
                email: true,
                minlength: 10,
                maxlength: 50
            },
            address: {
                required: false,
                minlength: 5,
                maxlength: 50
            }
        },
        errorLabelContainer: "#modalCreateCustomer .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#modalCreateCustomer .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalCreateCustomer .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalCreateCustomer .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#frmCreateCustomer input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            fullName: {
                required: "Vui lòng nhập tên đầy đủ",
                minlength: jQuery.validator.format("Họ tên tối thiểu {0} ký tự"),
                maxlength: jQuery.validator.format("Họ tên tối đa {0} ký tự")
            },
            email: {
                required: "Vui lòng nhập email đầy đủ",
                email: "Vui lòng nhập đúng định dạng email",
                minlength: jQuery.validator.format("Email tối thiểu {0} ký tự"),
                maxlength: jQuery.validator.format("Email tối đa {0} ký tự")
            },
            address: {
                minlength: jQuery.validator.format("Địa chỉ tối thiểu {0} ký tự"),
                maxlength: jQuery.validator.format("Địa chỉ tối đa {0} ký tự")
            }
        },
        submitHandler: function() {
            page.dialogs.commands.createCustomer();
        }
    });


    page.dialogs.elements.frmUpdateCustomer.validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        onfocusout: false,
        rules: {
            fullNameUp: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            emailUp: {
                required: true,
                email: true,
                minlength: 10,
                maxlength: 50
            }
        },
        errorLabelContainer: "#modalUpdateCustomer .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#modalUpdateCustomer .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalUpdateCustomer .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalUpdateCustomer .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#frmUpdateCustomer input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            fullNameUp: {
                required: "Vui lòng nhập tên đầy đủ",
                minLength: jQuery.validator.format("Họ tên tối thiểu {0} ký tự"),
                maxLength: jQuery.validator.format("Họ tên tối đa {0} ký tự")
            },
            emailUp: {
                required: "Vui lòng nhập email đầy đủ",
                email: "Vui lòng nhập đúng định dạng email",
                minlength: jQuery.validator.format("Email tối thiểu {0} ký tự"),
                maxlength: jQuery.validator.format("Email tối đa {0} ký tự")
            }
        },
        submitHandler: function() {
            page.dialogs.commands.updateCustomer();
        }
    });


    page.dialogs.elements.frmDeposit.validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        onfocusout: false,
        rules: {
            transactionAmountDep: {
                required: true,
                isNumberWithSpace: true,
                maxlength: 14
            }
        },
        errorLabelContainer: "#modalDeposit .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#modalDeposit .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalDeposit .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalDeposit .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#frmDeposit input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            transactionAmountDep: {
                required: "Vui lòng hoàn thiện thông tin này",
                maxlength: "Số tiền tối đa là 10.000.000.000"
            }
        },
        submitHandler: function() {
            page.dialogs.commands.depositMoney();
        }
    });


    page.dialogs.elements.frmWithdraw.validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        onfocusout: false,
        rules: {
            transactionAmountWd: {
                required: true,
                isNumberWithSpace: true,
                maxlength: 14
            }
        },
        errorLabelContainer: "#modalWithdraw .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#modalWithdraw .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalWithdraw .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalWithdraw .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#frmWithdraw input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            transactionAmountWd: {
                required: "Vui lòng hoàn thiện thông tin này",
                maxlength: "Số tiền tối đa là 10.000.000.000"
            }
        },
        submitHandler: function() {
            page.dialogs.commands.withdrawMoney();
        }
    });

    page.dialogs.elements.frmTransfer.validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        onfocusout: false,
        rules: {
            transferAmountTrf: {
                required: true,
                isNumberWithSpace: true,
                maxlength: 14
            }
        },
        errorLabelContainer: "#modalTransfer .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#modalTransfer .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalTransfer .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalTransfer .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#frmTransfer input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            transferAmountTrf: {
                required: "Vui lòng hoàn thiện thông tin này",
                maxlength: "Số tiền tối đa là 10.000.000.000"
            }
        },
        submitHandler: function() {
            page.dialogs.commands.transferMoney();
        }
    });

    $.validator.addMethod("isNumberWithSpace", function (value, element) {
        return this.optional(element) || /^\s*[0-9,\s]+\s*$/i.test(value);
    }, "Vui lòng nhập giá trị số");
});