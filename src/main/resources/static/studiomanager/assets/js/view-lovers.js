$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/tattoolovers/all", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var lover of data.content) {
                renderloverData(lover);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function renderloverData(lover) {
    var added_lover = document.getElementById("lover");
    console.log("30" + added_lover.innerHTML);
    var loverUsername = lover.username;
    added_lover.innerHTML =
        added_lover.innerHTML +
        `
  <tr>
  <td class="loverEmail" data-voucher-id="${loverUsername}">${lover.tattooLoveremail}</td>
  <td class="loverName" data-voucher-id="${loverUsername}">${lover.fullname}</td>
  <td class="loverUserName" data-voucher-id="${loverUsername}">${lover.username}</td>
  <td class="phoneNumber" data-voucher-id="${loverUsername}">${lover.phonenumber}</td>
  <td class="address" data-voucher-id="${loverUsername}">${lover.address}</td>
</tr>
`
}
