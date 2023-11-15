$(document).ready(function () {
    // Send an AJAX request
    $.ajax({
        type: "GET",
        url: "/service/list", // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (response) {
            var serviceSlickList = response.content;
            console.log(serviceSlickList)
            if(serviceSlickList && serviceSlickList.length > 0){
                // If there is more than one feedback, initialize the slider

                    $("#service_offer").not('.slick-initialized').slick({
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


                // Iterate through the feedback data and append to the slider
                $.each(serviceSlickList, function(index, service){
                    // Create a slide element and append it to the slider
                    var slide = `<div class="tab-item-slider">
                                <div class="tab-card">
                                    <div class="tab-card-inner">
                                        <div class="tab-card-image">
                                            <a href="#">
                                               <img src="${service.linkImage}" class="default-img">
                                            </a>
                                        </div>
                                        <div class="tab-card-content">
                                            
                                            <h4>
                                               <a href="#">
                                                ${service.serviceName}
                                               </a>
                                            </h4>
                                            <p>
                                                ${service.description}
                                            </p>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
             `;

                    $('#service_offer').slick('slickAdd', slide);
                });
            }
        },
        error: function(error){
            console.error('Error fetching feedback:', error);
        }
    });
});
