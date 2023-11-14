$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/booking/list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var booking of data) {
                renderBookingData(booking);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});





function renderBookingData(bookingData) {


    var added_booking = document.getElementById("booking");

    var bookingId = bookingData.bookingID;
    added_booking.innerHTML =
        added_booking.innerHTML +
        `
  <tr>
  <td class="bookingId" data-booking-id="${bookingId}">${bookingData.bookingID}</td>
  <td class="customerName" data-booking-id="${bookingId}">${bookingData.customerName}</td>
  <td class="tattooLoverEmail" data-booking-id="${bookingId}">${bookingData.tattooLoverEmail}</td>
  <td class="customerPhoneNumber" data-booking-id="${bookingId}">${bookingData.customerPhoneNumber}</td>
  <td class="address" data-booking-id="${bookingId}">${bookingData.address}</td>
  <td class="totalPrice" data-booking-id="${bookingId}">${bookingData.totalPrice}</td>
  <td><button onClick="handleDetail('${bookingId}')">Update</button></td>
</tr>
`
}
function handleDetail(bookingId) {
    let bookingID = document.querySelector(`.bookingId[data-booking-id="${bookingId}"]`).textContent;



    sessionStorage.setItem('BookingID', bookingID);
    window.location.href = "/view-bookingDetail.html";
}




