$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    var BookingID = sessionStorage.getItem("BookingID");
    $.ajax({
        type: "GET",
        url: "/bookingDetail/"+BookingID, // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var bookingDetail of data) {
                renderBookingDetailData(bookingDetail);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching bookingDetail data: " + error);
        }
    });
});


function renderBookingDetailData(bookingDetailData) {


    var added_bookingDetail = document.getElementById("bookingDetail");
    console.log("30" + added_bookingDetail.innerHTML);
    var bookingDetailID = bookingDetailData.bookingDetailID;
    added_bookingDetail.innerHTML =
        added_bookingDetail.innerHTML +
        `
  <tr>
  <td class="bookingDetailID" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.bookingDetailID}</td>
  <td class="bookingID" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.bookingID}</td>
  <td class="statusID" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.statusID}</td>
  <td class="description" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.description}</td>
  <td class="slotID" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.slotID}</td>
  <td class="serviceID" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.serviceID}</td>
    <td class="artistEmail" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.artistEmail}</td>
  <td class="voucherID" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.voucherID}</td>
  <td class="price" data-bookingDetail-id="${bookingDetailID}">${bookingDetailData.price}</td>
  
 
  <td><button onClick="handleUpdateStatus('${bookingDetailID}')">Update</button></td>
</tr>
`
}


