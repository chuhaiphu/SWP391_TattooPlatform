//Get service list
$(document).ready(function () {
    // Send an AJAX request
    var selectStudio = localStorage.getItem('selectedStudio')
    $.ajax({
        type: "GET",
        url: "/studio/name?studioName=" + studioName, // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (data) {
            renderStudioPage(data)
            // Add event listeners to each button
            // $(document).on('click', '#selectServiceBtn', function () {
            //     var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
            //     localStorage.setItem('selectedService', serviceName);
            //     window.location.href = 'studio-list.html';
            // });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});


function renderStudioPage(studio) {
    var service_template = $("#service-card_template").html();
    service_template = service_template.replace("{{imgSrc}}", service.linkImage);
    service_template = service_template.replace("{{serviceName}}", service.serviceName);
    var added_service = $("#service-card");
    $(service_template).appendTo(added_service);
}


