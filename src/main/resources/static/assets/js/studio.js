//Get service list
$(document).ready(function () {
    // Send an AJAX request
    $.ajax({
        type: "GET",
        url: "/studio/list", // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (data) {
            for (var studio of data){
                renderStudio(studio);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});

function renderStudio(studio) {
    var studio_template = $("#studio-card_template").html();

    // Replace placeholders in the template with product data
    studio_template = studio_template.replace("{{imgSrc}}", studio.bannerImg);
    studio_template = studio_template.replace("{{studioName}}", studio.studioName);
    studio_template = studio_template.replace("{{briefInfo}}", studio.briefInfo);

    var added_studio = $("#studio-card");
    $(studio_template).appendTo(added_studio);
}
// function renderService(service) {
//     var service_template = $("#service-card_template").html();
//     // Make another AJAX request to get studio name using studio ID
//     $.ajax({
//         type: "GET",
//         url: "/studio/manager/" + service.tattooManagerEmail, // Replace with the appropriate endpoint to fetch studio details
//         dataType: "json",
//         success: function (studio) {
//             // Replace placeholders in the template with service and studio data
//             service_template = service_template.replace("{{imageSrc}}", service.linkImage);
//             service_template = service_template.replace("{{studioName}}", studio.studioName);
//             service_template = service_template.replace("{{serviceName}}", service.serviceName);
//
//             var added_service = $("#service-card");
//             $(service_template).appendTo(added_service);
//         },
//         error: function (xhr, status, error) {
//             console.error("Error fetching studio: " + error);
//         }
//     });
// }