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

    // Add a click event listener to the icon
    document.getElementById("search-button-service").addEventListener("click", function() {
        // Get the input element
        const inputElement = document.querySelector(".search-input");

        let searchValue = inputElement.value;
        if (searchValue === null || searchValue.trim() === "") {
            searchValue = "";
        }
        console.log(searchValue);

        // Clear existing service cards
        const serviceContainer = document.getElementById("service-card");
        serviceContainer.innerHTML = ''; // Remove all child elements
        $.ajax({
            type: "GET",
            url: "/service/search?serviceName=" + searchValue, // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (data) {
                for (var service of data.content){
                    console.log(service);
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
});


function renderService(service) {
    var service_template = $("#service-card_template").html();
    service_template = service_template.replace("{{imgSrc}}", service.linkImage);
    service_template = service_template.replace("{{serviceName}}", service.serviceName);
    service_template = service_template.replace("{{serviceID}}", service.serviceID);
    var added_service = $("#service-card");
    $(service_template).appendTo(added_service);
}


