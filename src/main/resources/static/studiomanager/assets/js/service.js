$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/service/list", // Replace with the actual API endpoint
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
