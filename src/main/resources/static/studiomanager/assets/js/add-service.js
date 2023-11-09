



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

        // Check if the artist's email already exists
        $.ajax({
            type: "GET",
            url: "/service/check-name/" + serviceData.serviceName, // Replace with the actual API endpoint
            success: function (nameExists) {
                // If the email exists, show an error message
                if (nameExists) {
                    alert("Name is already in use.")
                    console.log("Name is already in use.");
                    $("#serviceName").val("");

                } else {
                    // If the email is not in use, proceed to add the artist
                    addService(serviceData);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error checking name: " + error);
                // Handle the error (e.g., show an error message to the user)
            }
        });
    });

    // Function to add the artist
    function addService(serviceData) {
        // Send an AJAX POST request to add the artist
        $.ajax({
            type: "POST",
            url: "/artist/add-service", // Replace with the actual API endpoint
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(serviceData),
            success: function (data) {
                // Handle the success response
                console.log("Service added successfully:", data);
                alert("Service added successfully!");
                window.location.href = "/view-service.html";
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error adding Service: " + error);

                alert("Error adding Service");

            }
        });
    }
});
