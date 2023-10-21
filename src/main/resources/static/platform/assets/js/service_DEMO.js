
$(document).ready(function () {
    // Send an AJAX request
    $.ajax({
        type: "GET",
        url: "/service/list", // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (data) {
            for (var service of data){
                renderService(service);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});

function renderService(service) {
    var service_template = $("#service-card_template").html();

    // Replace placeholders in the template with product data
    service_template = service_template.replace("{{imageSrc}}", service.linkImage);
    service_template = service_template.replace("{{tattooManagerEmail}}", service.tattooManagerEmail);
    service_template = service_template.replace("{{serviceName}}", service.serviceName);

    var added_service = $("#service-card");
    $(service_template).appendTo(added_service);
}


