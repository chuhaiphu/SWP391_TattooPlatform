$(document).ready(function () {
    $("#register-lover").click(function () {
        var loverData = {
            tattooLoveremail: $("#emailLover").val(),
            fullname: $("#fullNameLover").val(),
            phonenumber: $("#phoneNumberLover").val(),
            address: $("#addressLover").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            statusID: $("#status").val()

        };

        var confirmPassword = $("#comfirmPassword").val();
        var password = $("#password").val();
        if (password !== confirmPassword) {
            alert("Password not match");
            return;
        }
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/tattoolovers/add",
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(loverData),
            success: function  (data) {
                alert("Register success!");
                window.location.href = "login.html";
            },
            error: function (xhr, status, error) {
                alert("Error: " + error);
            }
        });
    });
});