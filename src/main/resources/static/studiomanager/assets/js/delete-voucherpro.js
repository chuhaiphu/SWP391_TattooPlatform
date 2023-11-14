$(document).ready(function () {
    const Voucher = JSON.parse(sessionStorage.getItem('Voucher'));
    document.getElementById('updateIdVoucher').value = Voucher.voucherID;
    document.getElementById('updateNameVoucher').value = Voucher.voucherName;
    document.getElementById('updateStartDateVoucher').value = Voucher.startDate;
    document.getElementById('updateEndDateVoucher').value = Voucher.endDate;
    document.getElementById('updateDescriptionVoucher').value = Voucher.description;
    document.getElementById('updateManagerEmail').value = Voucher.managerEmail;
    document.getElementById('updateDiscount').value = Voucher.discount;

    // Function to delete an artist
    function deleteVoucher(voucherID) {
        $.ajax({
            type: "DELETE",
            url: "/vouchers/" + voucherID,
            success: function (data) {
                console.log("Voucher deleted successfully:", data);
                alert("Voucher deleted successfully");
                window.location.href = "view-voucher.html"; // Redirect to the artist list page
            },
            error: function (xhr, status, error) {
                console.error("Error deleting voucher: " + error);
                alert("Error deleting voucher");

                // Optionally, display an error message to the user
            }
        });
    }

    // Event listener for the "Delete artist" button
    $("#delete-voucher").click(function () {
        var voucher = $("#updateIdVoucher").val();
        // Confirm before deleting
        Swal.fire({
            title: 'Are you sure?',
            text: 'You won\'t be able to revert this!',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                // If confirmed, call the deleteArtist function
                deleteVoucher(voucher);
            }
        });
    });

    // Rest of your code...
});
