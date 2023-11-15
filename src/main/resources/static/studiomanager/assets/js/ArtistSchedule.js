$(document).ready(function () {
    // Send an AJAX request to fetch artist data

    const artistUser = JSON.parse(sessionStorage.getItem('artist'));
    if (artistUser !== null) {
        $.ajax({
            type: "GET",
            url: "/bookingDetail/list/" + artistUser.content.email, // Replace with the actual API endpoint
            dataType: "json",
            success: function (data) {
            console.log(data.content)
                for (const bookingDetail of data.content) {
                    renderScheduleData(bookingDetail);

                }
            },
            error: function (xhr, status, error) {
                console.error("Error fetching booking detail data: " + error);
            }
        });
    }

    function renderScheduleData(scheduleData) {
        var added_bd = document.getElementById("schedule");
        var bdId = scheduleData.bookingDetailID;
        added_bd.innerHTML +=
            `
        <div class="schedule-item">
                    <div>
                        <h3 class="Service name" bdid="${bdId}">Service : ${scheduleData.service.serviceName}</h3>
                         <p class=" start Date" bdid="${bdId}">Date : ${scheduleData.slot.date}</p>
                         <p class="start time" bdid="${bdId}">${scheduleData.slot.startTime}</p>
                    </div>
                    <div class="schedule-details"  >
                        <p class="Customer name" bdid="${bdId}">Customer name : ${scheduleData.booking.customerName}</p>
                         <p class="Customer email" bdid="${bdId}">Customer email : ${scheduleData.booking.customerEmail}</p>
                         <p class="Customer phone number" bdid="${bdId}">Customer phone number : ${scheduleData.booking.customerPhoneNumber}</p>
                         <p class="Description" bdid="${bdId}">${scheduleData.description}</p>
                    </div>
                </div>
         
     `;
    }


});
