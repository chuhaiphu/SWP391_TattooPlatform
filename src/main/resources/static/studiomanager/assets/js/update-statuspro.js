$(document).ready(function () {
    const status = JSON.parse(sessionStorage.getItem('Status'));

    document.getElementById('bookingDetailID').value = status.bookingDetailID;
    document.getElementById('selectOption').value = status.statusID;

    // Set the src attribute of the img element

    $("#update-status").click(function () {
        // Get the values from input fields
        var bookingDetailID = $("#bookingDetailID").val();
        var statusID = $("#selectOption").val();

        $.ajax({
            type: "PUT",
            url: "/bookingDetail/updateStatus/" + bookingDetailID + "?statusID=" + statusID,
            contentType: "application/json; charset-utf-8",
            success: function (data) {
                // Handle the success response
                console.log("Status updated successfully:", data);

                // Optionally, you can display a success message and redirect the user.
                // For example, you can redirect back to the artist list page:
                window.location.href = "view-bookingDetail.html";
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error updating Status: " + error);

                // Optionally, you can display an error message to the user.
            }
        });

        // Send an AJAX POST request to update the service
        // Add your AJAX code here
    });
});