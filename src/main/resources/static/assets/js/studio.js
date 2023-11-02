$(document).ready(function () {
    let selectedServiceName = sessionStorage.getItem("selectedServiceName")
    if(!selectedServiceName) {
        // Send an AJAX request
        $.ajax({
            type: "GET",
            url: "/studio/list", // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (response) {
                for (var studio of response.content) {
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
            url: "/studio/list/" + selectedServiceName, // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (response) {
                for (var studio of response.content) {
                    renderStudio(studio);
                }
                handleViewStudioBtn();
            },
            error: function (xhr, status, error) {
                console.error("Error fetching service: " + error);
            }
        });
    }

    document.getElementById("search-button-studio").addEventListener("click", function() {
        // Get the input element
        const inputElement = document.querySelector(".search-input");

        let searchValue = inputElement.value;
        if (searchValue === null || searchValue.trim() === "") {
            searchValue = "";
        }
        console.log(searchValue);

// Clear existing service cards
        const studioContainer = document.getElementById("studio-card");
        studioContainer.innerHTML = ''; // Remove all child elements
        $.ajax({
            type: "GET",
            url: "/studio/search?studioName=" + searchValue, // Replace with the actual URL to your endpoint
            dataType: "json",
            success: function (data) {
                for (var studio of data.content){
                    console.log(studio);
                    renderStudio(studio);
                }

                // Add event listeners to each button
                handleViewStudioBtn();
            },
            error: function (xhr, status, error) {
                console.error("Error fetching service: " + error);
            }
        });
    });
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
        var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
        var studioID = $(this).closest('.product-card-content').find('.studio-id').text().trim(); // Get studioID
        sessionStorage.setItem('selectedStudioID', studioID); // Save studioID to sessionStorage
        sessionStorage.setItem('selectedStudioName', studioName);
        window.location.href = 'view-studio.html';
    });
}
// function handleBookingBtn(){
//     // Add event listeners to each button
//     $(document).on('click', '#booking-btn', function () {
//         var studioName = $(this).closest('.product-card-content').find('h4').text().trim();
//         var studioID = $(this).closest('.product-card-content').find('.studio-id').text().trim();
//         sessionStorage.setItem('selectedStudioName', studioName); // Save studioID to localStorage
//         sessionStorage.setItem('selectedStudioID', studioID);
//         window.location.href = 'appointment-page.html';
//     });
// }