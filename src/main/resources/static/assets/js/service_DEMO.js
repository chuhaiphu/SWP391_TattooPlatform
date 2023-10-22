//Get service list
$(document).ready(function () {
    // Send an AJAX request
    $.ajax({
        type: "GET",
        url: "/service/list", // Replace with the actual URL to your endpoint
        dataType: "json",
        success: function (data) {
            for (var service of data){
                renderService(service);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching service: " + error);
        }
    });
});

// function renderService(service) {
//     var service_template = $("#service-card_template").html();
//
//     // Replace placeholders in the template with product data
//     service_template = service_template.replace("{{imageSrc}}", service.linkImage);
//     service_template = service_template.replace("{{tattooManagerEmail}}", service.tattooManagerEmail);
//     service_template = service_template.replace("{{serviceName}}", service.serviceName);
//
//     var added_service = $("#service-card");
//     $(service_template).appendTo(added_service);
// }
function renderService(service) {
    var service_template = $("#service-card_template").html();
    // Make another AJAX request to get studio name using studio ID
    $.ajax({
        type: "GET",
        url: "/studio/manager/" + service.tattooManagerEmail, // Replace with the appropriate endpoint to fetch studio details
        dataType: "json",
        success: function (studio) {
            // Replace placeholders in the template with service and studio data
            service_template = service_template.replace("{{imgSrc}}", service.linkImage);
            service_template = service_template.replace("{{studioName}}", studio.studioName);
            service_template = service_template.replace("{{serviceName}}", service.serviceName);

            var added_service = $("#service-card");
            $(service_template).appendTo(added_service);
        },
        error: function (xhr, status, error) {
            console.error("Error fetching studio: " + error);
        }
    });
}
//View studio
// $(document).ready(function() {
//     // Get the query parameter from the URL
//     const urlParams = new URLSearchParams(window.location.search);
//     const studioNameEncoded = urlParams.get('studioName');
//     const studioName = decodeURIComponent(studioNameEncoded);
//
//     // Make an AJAX request to fetch data based on the studio name
//     $.ajax({
//         type: "GET",
//         url: "/view-studio?studioName=" + studioName, // Replace with the appropriate endpoint to fetch data
//         dataType: "json",
//         success: function(data) {
//             // Handle the response data
//             console.log(data);
//         },
//         error: function(xhr, status, error) {
//             console.error("Error fetching data: " + error);
//         }
//     });
// });


