var cart = [];
localStorage.setItem('cart', JSON.stringify(cart));
// var existedCart = JSON.parse(localStorage.getItem('cart'));
// if(existCart == null){
//     localStorage.setItem('cart', JSON.stringify(cart));
// }else{
//     var existedCartConfirm = confirm("You are in booking a service")
// }
//Get service list
$(document).ready(function () {
    // Send an AJAX request
    $.ajax({
        type: "GET",
        url: "/service/list", // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (response) {
            for (var service of response.content){
                renderService(service);
            }
            // Add event listeners to each button
            $(document).on('click', '#selectServiceBtn', function () {
                var serviceName = $(this).closest('.product-card-content').find('h4').text().trim();
                sessionStorage.setItem('selectedServiceName', serviceName);
                var serviceID = $(this).closest('.product-card-content').find('.service-id').text().trim(); // Get serviceID
                sessionStorage.setItem('selectedServiceID', serviceID); // Save serviceID to sessionStorage
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
    service_template = service_template.replace("{{serviceID}}", service.serviceID);
    var added_service = $("#service-card");
    $(service_template).appendTo(added_service);
}


