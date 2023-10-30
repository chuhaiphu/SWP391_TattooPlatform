$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/view-booking/list", // Replace with the actual API endpoint
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
    var bookingTable = $("#bookingList_template").html();
    bookingTable = bookingTable.replace("{{bookingID}}", bookingData.bookingID );
    bookingTable = bookingTable.replace("{{customerName}}", bookingData.customerName );
    bookingTable = bookingTable.replace("{{tattooLoverEmail}}", bookingData.tattooLoverEmail );
    bookingTable = bookingTable.replace("{{customerPhoneNumber}}", bookingData.customerPhoneNumber );
    bookingTable = bookingTable.replace("{{address}}", bookingData.address );
    bookingTable = bookingTable.replace("{{totalPrice}}", bookingData.totalPrice);


    var added_booking = $("#booking");
    $(bookingTable).appendTo(added_booking);

}
