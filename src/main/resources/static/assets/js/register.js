$(document).ready(function () {
    $("#register-lover").click(function () {
        var artistData = {
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
        $.ajax({
            type: "POST",
            url: "/tattoolovers/add",
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(artistData),
            success: function (response) {

                alert("Register success!");

            },
            error: function (xhr, status, error) {
                alert("Error: " + error);
            }
        });
    });
});