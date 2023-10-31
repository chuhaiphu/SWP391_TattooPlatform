$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/service/view-list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var service of data) {
                renderserviceData(service);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function renderserviceData(serviceData) {
    var serviceTable = $("#serviceList_template").html();
    serviceTable = serviceTable.replace("{{serviceID}}", serviceData.serviceID );
    serviceTable = serviceTable.replace("{{serviceName}}", serviceData.serviceName );
    serviceTable = serviceTable.replace("{{description}}", serviceData.description );
    serviceTable = serviceTable.replace("{{linkImage}}", serviceData.linkImage );
    serviceTable = serviceTable.replace("{{tattooManagerEmail}}", serviceData.tattooManagerEmail );
    serviceTable = serviceTable.replace("{{price}}", serviceData.price );


    var added_service = $("#service");
    $(serviceTable).appendTo(added_service);

}

function deleteService(serviceID) {
    if (confirm("Are you sure you want to delete this service?")) {
        $.ajax({
            type: "DELETE",
            url: "/service/" + serviceID, // Replace with the actual API endpoint
            success: function (data) {
                console.log("Service deleted:", data);
                // Handle success, e.g., remove the service row from the table
                $(`#${serviceID}`).remove();
                // Optionally, you can display a success message to the user.
            },
            error: function (xhr, status, error) {
                console.error("Error deleting service: " + error);
                // Handle the error, e.g., display an error message to the user.
            }
        });
    }
}
