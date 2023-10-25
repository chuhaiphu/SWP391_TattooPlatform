$(document).ready(function () {
    let selectedServiceName = sessionStorage.getItem("selectedServiceName")
    if(!selectedServiceName) {
        // Send an AJAX request
        $.ajax({
            type: "GET",
            url: "/studio/list", // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (data) {
                for (var studio of data) {
                    renderStudio(studio);
                }
                sessionStorage.removeItem("selectedServiceName");
                handleViewStudioBtn();
            },
            error: function (xhr, status, error) {
                console.error("Error fetching service: " + error);
            }
        });
    }else{
        $.ajax({
            type: "GET",
            url: "/studio/service-list?serviceName=" + selectedServiceName, // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (data) {
                for (var studio of data) {
                    renderStudio(studio);
                }
                handleBookingBtn();
                handleViewStudioBtn();
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
    studio_template = studio_template.replace("{{studioID}}", studio.studioID); // Add studioID
    var added_studio = $("#studio-card");
    $(studio_template).appendTo(added_studio);
}
function handleViewStudioBtn(){
    // Add event listeners to each button
    $(document).on('click', '#view-studio-btn', function () {
        //var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
        var studioID = $(this).closest('.product-card-content').find('.studio-id').text().trim(); // Get studioID
        sessionStorage.setItem('selectedStudioID', studioID); // Save studioID to sessionStorage
        //sessionStorage.setItem('selectedStudioName', studioName);
        window.location.href = 'view-studio.html';
    });
}
function handleBookingBtn(){
    // Add event listeners to each button
    $(document).on('click', '#booking-btn', function () {
        var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
        
        sessionStorage.setItem('selectedStudioName', studioName); // Save studioID to localStorage
        
        window.location.href = 'appointment-page.html';
    });
}