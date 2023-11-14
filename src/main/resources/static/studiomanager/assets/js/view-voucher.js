$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/vouchers/list", // Replace with the actual API endpoint
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


    var added_voucher = document.getElementById("voucher");
    console.log("30" + added_voucher.innerHTML);
    var voucherId = voucherData.voucherID;
    added_voucher.innerHTML =
        added_voucher.innerHTML +
        `
  <tr>
  <td class="voucherID" data-voucher-id="${voucherId}">${voucherData.voucherID}</td>
  <td class="voucherName" data-voucher-id="${voucherId}">${voucherData.voucherName}</td>
  <td class="startDate" data-voucher-id="${voucherId}">${voucherData.startDate}</td>
  <td class="endDate" data-voucher-id="${voucherId}">${voucherData.endDate}</td>
  <td class="description" data-voucher-id="${voucherId}">${voucherData.description}</td>
  <td class="managerEmail" data-voucher-id="${voucherId}">${voucherData.managerEmail}</td>
  <td class="discount" data-voucher-id="${voucherId}">${voucherData.discount}</td>
  <td><button onClick="handleUpdate('${voucherId}')">Delete</button></td>
</tr>
`
}
