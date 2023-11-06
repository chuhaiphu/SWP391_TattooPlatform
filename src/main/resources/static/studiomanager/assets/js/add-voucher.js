$(document).ready(function () {
    $("#add-voucher").click(function () {
        // Capture form data
        var voucherData = {
            voucherName: $("#nameVoucher").val(),
            startDate: $("#addStartDateVoucher").val(),
            endDate: $("#addEndDateVoucher").val(),
            description: $("#descriptionVoucher").val(),
            managerEmail: $("#managerEmail").val(),
            discount: $("#discount").val()
        };

        // Send an AJAX POST request to add the voucher
        $.ajax({
            type: "POST",
            url: "/vouchers/add-voucher", // Replace with the actual API endpoint
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(voucherData),
            success: function (data) {
                // Handle the success response
                console.log("Voucher added successfully:", data);

                // Clear the input fields
                $("#nameVoucher").val("");
                $("#addStartDateVoucher").val("");
                $("#addEndDateVoucher").val("");
                $("#descriptionVoucher").val("");
                $("#managerEmail").val("");
                $("#discount").val("");

                // Display a success message (you can customize this part)
                $("#successMessage").text("Voucher added successfully!");
                $("#successMessage").show();

                // Optionally, you can redirect the user or perform other actions.
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error adding voucher: " + error);

                // Display an error message (you can customize this part)
                $("#errorMessage").text("Error adding voucher!");
                $("#errorMessage").show();

                // Optionally, you can provide error feedback to the user.
            }
        });
    });
});