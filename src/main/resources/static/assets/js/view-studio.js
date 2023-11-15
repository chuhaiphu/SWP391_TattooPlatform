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
    $.ajax({
        url: '/feedback/allFeedback/' + selectStudioID, // Adjust the path accordingly
        method: 'GET',
        dataType: 'json',
        success: function(data){
            // Process the fetched data
            var feedbacks = data.content;
            console.log(feedbacks);
            if(feedbacks && feedbacks.length > 0){
                // If there is more than one feedback, initialize the slider
                if (feedbacks.length > 1) {
                    $('.testimonials-main').slick({
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        arrows: true,
                        speed: 1200,
                        dots: true,
                        loop: true,
                        infinite: true,
                        centerMode: true,
                        responsive: [
                          {
                            breakpoint: 768,
                            settings: {
                              slidesToShow: 2,
                            },
                          },
                          {
                            breakpoint: 500,
                            settings: {
                              slidesToShow: 1,
                            },
                          }
                        ],
                      });
                }

                // Iterate through the feedback data and append to the slider
                $.each(feedbacks, function(index, feedback){
                    // Create a slide element and append it to the slider
                    var slide = '<div class="testi-slides"><div class="testi-inner">' +
                        '<h2>' + feedback.bookingDetail.service.serviceName + '</h2>' +
                        '<p>' + feedback.description + '</p>' +
                        '<div class="bottom-content">' +
                        '<div class="user-name">' +
                        '<div class="testi-img-wrapper">' +
                        '<img src="assets/images/testi-user.png" alt="user">' +
                        '</div>' +
                        '<a href="#">' + feedback.bookingDetail.booking.customerName + '</a>' +
                        '</div>' +
                        '<div class="ratings d-flex justify-content-center align-items-center">' +
                        '<img src="assets/images/ratings.png" alt="star">' +
                        '<span>' + feedback.artistRating + ' / 5.0</span>' +
                        '</div>' +
                        '</div>' +
                        '</div></div>';

                    $('.testimonials-main').slick('slickAdd', slide);   
                });
            }else {
               

                $('.testimonials-main').html('<div class="testi-slides"><div class="testi-inner">' +
                '<h3>Oops! Looks like this studio has not received any feedback yet!</h3>' +
                '</div></div>');
            }
        },
        error: function(error){
            console.error('Error fetching feedback:', error);
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
            alert("Please login first to book appointment!!!")
        }
    });
}
function renderFeedback(feedback) {
    const feedbackContainer = document.getElementById('feedbacks-container');

    const feedbackDiv = document.createElement('div');
    feedbackDiv.className = 'testi-slides';

    feedbackDiv.innerHTML = `
        <div class="testi-inner">
            <h2>${feedback.title}</h2>
            <p>${feedback.content}</p>
            <div class="bottom-content d-flex justify-content-center align-items-center">
                <div class="ratings d-flex justify-content-center align-items-center">
                    <img src="assets/images/ratings.png" alt="star">
                    <span>${feedback.rating} / 5.0</span>
                 </div>
                 <div class="user-name">
                     <div class="testi-img-wrapper">
                         <img src="assets/images/testi-user.png" alt="user">
                     </div>
                     <a href="#">${feedback.tattooLoverEmail}</a>
                </div>
            </div>
        </div>
    `;

    feedbackContainer.appendChild(feedbackDiv);
    
}
function renderStudioPage(data) {
    $('#studio-name').find('h2').text(data.content.studio.studioName);
    $('#content').find('p').text(data.content.studio.content);
    var bannerImgElement2 = document.getElementById('bannerImage2');
    var bannerImgElement1 = document.getElementById('bannerImage1');
    bannerImgElement1.src = data.content.studio.bannerImg;
    bannerImgElement2.src = data.content.studio.bannerImg;
    console.log(bannerImgElement2.src)
    
}



// Example function to retrieve artist average rates from the database

function renderServiceCard(service){
    var service_card_template = $("#service-booking-card_template").html();
    service_card_template = service_card_template.replace("{{imgSrc}}", service.linkImage);
    service_card_template = service_card_template.replace("{{serviceName}}", service.serviceName);
    service_card_template = service_card_template.replace("{{serviceID}}", service.serviceID);
    service_card_template = service_card_template.replace("{{price}}", service.price);
    var added_service_card = $("#service-booking-card");
    $(service_card_template).appendTo(added_service_card);
}


