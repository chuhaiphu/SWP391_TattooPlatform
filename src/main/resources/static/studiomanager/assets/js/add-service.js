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

        // Send an AJAX GET request to check for duplicate service name
        $.ajax({
            type: "GET",
            url: "/service/check-duplicate?serviceName=" + serviceData.serviceName,
            success: function (result) {
                if (result === true) {
                    // Display an error message for duplicate service name
                    alert("Service name already exists!");
                    console.log("Service name already exists!");
                    $("#serviceName").val("");

                } else {
                    // If the service name is not a duplicate, send a POST request to add the service
                    $.ajax({
                        type: "POST",
                        url: "/service/add-service",
                        contentType: "application/json; charset-utf-8",
                        data: JSON.stringify(serviceData),
                        success: function (data) {
                            // Handle the success response
                            console.log("Service added successfully:", data);
                            alert("Service added successfully!");
                            window.location.href = "/view-service.html";

                            // Clear the input fields

                            // Optionally, you can redirect the user or perform other actions.
                        },
                        error: function (xhr, status, error) {
                            // Handle the error
                            console.error("Error adding Service: " + error);
                            alert("Error adding Service!")

                            // Display an error message (you can customize this part)

                            // Optionally, you can provide error feedback to the user.
                        }
                    });
                }
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error checking duplicate service name: " + error);
                alert("Error checking duplicate service name!")
            }
        });
    });
});
