$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/view-tattoolovers/list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var lover of data) {
                renderArtistData(lover);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function renderArtistData(loverData) {


    var added_lover = document.getElementById("artist");
    console.log("30" + added_lover.innerHTML);
    var loverId = loverData.email;
    added_lover.innerHTML =
        added_lover.innerHTML +
        `
  <tr>
  <td class="email" data-lover-id="${loverId}">${loverData.email}</td>
  <td class="fullName" data-lover-id="${loverId}">${loverData.fullName}</td>
  <td class="username" data-lover-id="${loverId}">${loverData.username}</td>
  <td class="password" data-lover-id="${loverId}">${loverData.password}</td>
  <td class="phoneNumber" data-lover-id="${loverId}">${loverData.phoneNumber}</td>
  <td class="address" data-lover-id="${loverId}">${loverData.address}</td>
  <td><button onClick="handleUpdate('${loverId}')">Update</button></td>
</tr>
`
}

