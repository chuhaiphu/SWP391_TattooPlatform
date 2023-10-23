//Get service list
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


            // Add event listeners to each button
            $(document).on('click', '#selectServiceBtn', function () {
                var serviceName = $(this).closest('.product-card-content').find('h4').text().trim();
                localStorage.setItem('selectedServiceName', serviceName);
                window.location.href = "/studio";
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});


function renderService(service) {
    var service_template = $("#service-card_template").html();
    service_template = service_template.replace("{{imgSrc}}", service.linkImage);
    service_template = service_template.replace("{{serviceName}}", service.serviceName);
    var added_service = $("#service-card");
    $(service_template).appendTo(added_service);
}

