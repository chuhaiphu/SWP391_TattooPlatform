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


        // Check if start date is later than end date
        if (new Date(voucherData.startDate) > new Date(voucherData.endDate)) {
            alert("Start date cannot be later than end date.");
            $("#addStartDateVoucher").val("");
            $("#addEndDateVoucher").val("");
            return;
        }

        // Check if the voucher's name already exists
        $.ajax({
            type: "GET",
            url: "/vouchers/check-name/" + voucherData.voucherName,
            success: function (nameExists) {
                if (nameExists) {
                    // If the name exists, show an error message
                    alert("Voucher name is already in use.");
                    console.log("Voucher name is already in use.");
                    $("#nameVoucher").val("");
                } else {
                    addVoucher(voucherData);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error checking Voucher: " + error);
                alert("Error checking Voucher.");
            }
        });
    });

    // Function to add the voucher
    function addVoucher(voucherData) {
        $.ajax({
            type: "POST",
            url: "/vouchers/add-voucher",
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(voucherData),
            success: function (data) {
                console.log("Voucher added successfully:", data);
                alert("Voucher added successfully.")
                window.location.href = "/view-voucher.html";
            },
            error: function (xhr, status, error) {
                console.error("Error adding Voucher: " + error);
                alert("Error adding Voucher.");
            }
        });
    }
});
