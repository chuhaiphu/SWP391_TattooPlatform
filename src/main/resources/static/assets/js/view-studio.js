//Get service list
$(document).ready(function () {
    // Send an AJAX request
    var selectStudioID = sessionStorage.getItem('selectedStudioID')
    $.ajax({
        type: "GET",
        url: "/studio/studioService/" + selectStudioID, // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (data) {
            console.log(data)
            console.log(data.content.studio.studioName)
            console.log(data.content.service.price)
            renderStudioPage(data);
            var services = data.content.service;
            services.forEach(function(service) {
                renderServiceCard(service)
            });
            handleBookingBtn(data);
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});

function handleBookingBtn(data){
    $(document).on('click', '#booking-btn', function () {
        var serviceName = $(this).siblings('h2').text().trim();
        var serviceID = $(this).siblings('h3').text().trim();
        var servicePrice = $(this).siblings('p').text().trim();
        sessionStorage.setItem('selectedServiceName', serviceName);
        sessionStorage.setItem('selectedServiceID', serviceID); 
        sessionStorage.setItem('selectedServicePrice', servicePrice); 
        sessionStorage.setItem('selectedStudioName', data.content.studio.studioName); 
        window.location.href = 'appointment-page.html ';
    });
}
function renderStudioPage(data) {
    $('#studio-name').find('h2').text(data.content.studio.studioName);
    $('#content').find('p').text(data.content.studio.content);
}
function renderServiceCard(service){
    var service_card_template = $("#service-booking-card_template").html();
    service_card_template = service_card_template.replace("{{serviceName}}", service.serviceName);
    service_card_template = service_card_template.replace("{{serviceID}}", service.serviceID);
    service_card_template = service_card_template.replace("{{price}}", service.price);
    var added_service_card = $("#service-booking-card");
    $(service_card_template).appendTo(added_service_card);
}


