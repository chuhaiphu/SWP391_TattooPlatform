$(document).ready(function () {
    $("#add-service").click(function () {
        // Capture form data
        var serviceData = {
            serviceName: $("#serviceName").val(),
            description: $("#descriptionService").val(),
            linkImage: $("#linkImage").val(),
            tattooManagerEmail: $("#tattooManagerEmail").val(),
            price: $("#price").val()
        };

        // Send an AJAX POST request to add the voucher
        $.ajax({
            type: "POST",
            url: "/service/addService", // Replace with the actual API endpoint
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(serviceData),
            success: function (data) {
                // Handle the success response
                console.log("Service added successfully:", data);

                // Clear the input fields
                $("#serviceName").val("");
                $("#descriptionService").val("");
                $("#linkImage").val("");
                $("#tattooManagerEmail").val("");
                $("#price").val("");

                // Display a success message (you can customize this part)
                $("#successMessage").text("Service added successfully!");
                $("#successMessage").show();

                // Optionally, you can redirect the user or perform other actions.
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error adding Service: " + error);

                // Display an error message (you can customize this part)
                $("#errorMessage").text("Error adding service!");
                $("#errorMessage").show();

                // Optionally, you can provide error feedback to the user.
            }
        });
    });
});