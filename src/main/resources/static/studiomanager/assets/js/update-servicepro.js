$(document).ready(function () {
    const service = JSON.parse(sessionStorage.getItem('Service'));

    document.getElementById('serviceID').value = service.serviceID;
    document.getElementById('updateServiceName').value = service.serviceName;
    document.getElementById('updateDescriptionService').value = service.description;
    document.getElementById('updatePriceService').value = service.price;
    document.getElementById('updateImageService').value = service.linkImage;

    // Set the src attribute of the img element

    $("#update-service").click(function () {
        // Get the values from input fields
        var serviceID = $("#serviceID").val();
        var serviceName = $("#updateServiceName").val();
        var description = $("#updateDescriptionService").val();
        var price = $("#updatePriceService").val();

        // Retrieve the src attribute from the img element
        var linkImage = $("#updateImageService").val();

        // Create a data object to send via AJAX
        var data = {
            serviceID: serviceID,
            serviceName: serviceName,
            description: description,
            price: price,
            linkImage: linkImage,
        };
        $.ajax({
            type: "PUT",
            url: "/service/update-service/" + serviceID + "?serviceName=" + serviceName + "&description=" + description + "&price=" + price + "&linkImage=" + linkImage,
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(data),
            success: function (data) {
                // Handle the success response
                console.log("Service updated successfully:", data);

                // Optionally, you can display a success message and redirect the user.
                // For example, you can redirect back to the artist list page:
                window.location.href = "view-service.html";
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error updating service: " + error);

                // Optionally, you can display an error message to the user.
            }
        });

        // Send an AJAX POST request to update the service
        // Add your AJAX code here
    });
});