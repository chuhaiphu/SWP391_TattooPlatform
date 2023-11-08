$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/vouchers/view-list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var voucher of data.content) {
                rendervoucherData(voucher);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function rendervoucherData(voucherData) {
    var voucherTable = $("#voucherList_template").html();
    voucherTable = voucherTable.replace("{{voucherID}}", voucherData.voucherID );
    voucherTable = voucherTable.replace("{{voucherName}}", voucherData.voucherName );
    voucherTable = voucherTable.replace("{{startDate}}", voucherData.startDate );
    voucherTable = voucherTable.replace("{{endDate}}", voucherData.endDate );
    voucherTable = voucherTable.replace("{{description}}", voucherData.description );
    voucherTable = voucherTable.replace("{{discount}}", voucherData.discount );


    var added_voucher = $("#voucher");
    $(voucherTable).appendTo(added_voucher);

}
