var cart = JSON.parse(localStorage.getItem('cart'))
//Get service list
$(document).ready(function () {
    // Send an AJAX request
    var selectStudioID = sessionStorage.getItem('selectedStudioID')
    var tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    $.ajax({
        type: "GET",
        url: "/studio/studioService/" + selectStudioID, // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (data) {
            renderStudioPage(data);
            var services = data.content.service;
            services.forEach(function(service) {
                renderServiceCard(service)
            });
           
            handleBookingBtn(data, tattooLover);
            handleAddToCartBtn(data, tattooLover);
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});
document.querySelector('.back-btn').addEventListener('click', function() {
    window.history.back();
});

function handleAddToCartBtn(data, tattooLover){
    $(document).on('click', '#add-to-cart-btn', function () {
        event.preventDefault();
        if(tattooLover != null){        
            var serviceImg = $(this).siblings('h4').text().trim();
            var serviceName = $(this).siblings('h2').text().trim();
            var serviceID = $(this).siblings('h3').text().trim();
            var servicePrice = $(this).siblings('p').text().trim();
            var addedService = {
                "serviceImg" : serviceImg,
                "serviceName": serviceName,
                "serviceID": serviceID,
                "servicePrice": servicePrice,
                "studioID": data.content.studio.studioID,
                "studioName": data.content.studio.studioName,
            }
            var found = false;
            var studioNameNotMatch = false;
            for (var i = 0; i < cart.length; i++) {
                if (cart[i].serviceID === addedService.serviceID) {
                    found = true;
                    break;
                }
                if (cart[i].studioName != addedService.studioName) {
                    studioNameNotMatch = true;
                    break
                }
            }
            if(found){
                alert("Cart already have that service!!!");
            }else if(studioNameNotMatch){
                var confirmation = confirm("You are booking another studio. Do you want to discard current cart and book with another studio ?");
                if(confirmation){
                    cart.splice(0, cart.length);
                    cart.push(addedService); // Add the new service to the cart
                    localStorage.setItem('cart', JSON.stringify(cart)); // Store the updated cart in local storage
                    var cartConfirm = confirm("Added sucessfully! Do you want to view cart now?");
                    if(cartConfirm){
                        window.location.href = "cart.html"
                    }
                }
            }else{
                cart.push(addedService); // Add the item to the cart
                localStorage.setItem('cart', JSON.stringify(cart)); // Store the updated cart in local storage
                var cartConfirm = confirm("Added sucessfully! Do you want to view cart now?");
                if(cartConfirm){
                    window.location.href = "cart.html"
                }
            }
        
        }else{
            alert("Please login first to use this feature")
        }
    });
}

function handleBookingBtn(data, tattooLover){
    $(document).on('click', '#booking-btn', function () {
        event.preventDefault();
        if(tattooLover != null){
            var serviceImg = $(this).siblings('h4').text().trim();
            var serviceName = $(this).siblings('h2').text().trim();
            var serviceID = $(this).siblings('h3').text().trim();
            var servicePrice = $(this).siblings('p').text().trim();
            var addedService = {
                "serviceImg" : serviceImg,
                "serviceName": serviceName,
                "serviceID": serviceID,
                "servicePrice": servicePrice,
                "studioID": data.content.studio.studioID,
                "studioName": data.content.studio.studioName,
            }

            if (cart.length > 0) {
                var confirmation = confirm("The cart already contains a service. Do you want to discard the current cart and book the new one?");
                if (confirmation) {
                    cart.splice(0, cart.length);
                    cart.push(addedService); // Add the new service to the cart
                    localStorage.setItem('cart', JSON.stringify(cart)); // Store the updated cart in local storage
                    window.location.href = "appointment-page.html"
                }
            } else {
                cart.push(addedService); // Add the item to the cart
                localStorage.setItem('cart', JSON.stringify(cart)); // Store the updated cart in local storage
                window.location.href = "appointment-page.html"
            }
        }else{
            alert("please login")
        }
    });
}

function renderStudioPage(data) {
    $('#studio-name').find('h2').text(data.content.studio.studioName);
    $('#content').find('p').text(data.content.studio.content);
}
function renderServiceCard(service){
    var service_card_template = $("#service-booking-card_template").html();
    service_card_template = service_card_template.replace("{{imgSrc}}", service.linkImage);
    service_card_template = service_card_template.replace("{{serviceName}}", service.serviceName);
    service_card_template = service_card_template.replace("{{serviceID}}", service.serviceID);
    service_card_template = service_card_template.replace("{{price}}", service.price);
    var added_service_card = $("#service-booking-card");
    $(service_card_template).appendTo(added_service_card);
}


