$(document).ready(function () {
    let selectedService = localStorage.getItem("selectedService")
    if(!selectedService) {
        // Send an AJAX request
        $.ajax({
            type: "GET",
            url: "/studio/list", // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (data) {
                for (var studio of data) {
                    renderStudio(studio);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error fetching service: " + error);
            }
        });
    }else{
        $.ajax({
            type: "GET",
            url: "/studio/service-list?serviceName=" + selectedService, // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (data) {
                console.log(data);
                for (var studio of data) {
                    renderStudio(studio);
                }
                handleBookingBtn();
            },
            error: function (xhr, status, error) {
                console.error("Error fetching service: " + error);
            }
        });
    }
});

function renderStudio(studio) {
    var studio_template = $("#studio-card_template").html();
    studio_template = studio_template.replace("{{imgSrc}}", studio.bannerImg);
    studio_template = studio_template.replace("{{studioName}}", studio.studioName);
    studio_template = studio_template.replace("{{briefInfo}}", studio.briefInfo);
    var added_studio = $("#studio-card");
    $(studio_template).appendTo(added_studio);
}
function handleBookingBtn(){
    $(document).on('click', '#booking-btn', function () {
        var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
        localStorage.setItem('selectedStudioName', studioName);
        window.location.href = '/appointment-page.html';
    });
}
