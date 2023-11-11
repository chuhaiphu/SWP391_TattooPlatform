$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/service/list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var service of data.content) {
                renderserviceData(service);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});


function renderserviceData(serviceData) {


    var added_service = document.getElementById("service");
    console.log("30" + added_service.innerHTML);
    var serviceId = serviceData.serviceID;
    added_service.innerHTML =
        added_service.innerHTML +
        `
  <tr>
  <td class="serviceID" data-service-id="${serviceId}">${serviceData.serviceID}</td>
  <td class="serviceName" data-service-id="${serviceId}">${serviceData.serviceName}</td>
  <td class="description" data-service-id="${serviceId}">${serviceData.description}</td>
  <td data-service-id="${serviceId}"><img src="${serviceData.linkImage}" alt="Service Image" style="width: 100px; height: 100px;"></td>
  <td class="tattooManagerEmail" data-service-id="${serviceId}">${serviceData.tattooManagerEmail}</td>
  <td class="price" data-service-id="${serviceId}">${serviceData.price}</td>
  <td><button onClick="handleUpdate('${serviceId}')">Update</button></td>
</tr>
`
}


