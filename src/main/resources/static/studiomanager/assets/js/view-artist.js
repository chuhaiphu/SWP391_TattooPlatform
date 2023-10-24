$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/view-artist/list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var artist of data) {
                renderArtistData(artist);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function renderArtistData(artistData) {


    var added_artist = document.getElementById("artist");
    console.log("30" + added_artist.innerHTML);
    added_artist.innerHTML =
        added_artist.innerHTML +
        `
  <tr>
  <td id="email">${artistData.email}</td>
  <td id="fullName">${artistData.fullName}</td>
  <td id="username">${artistData.username}</td>
  <td id="password">${artistData.password}</td>
  <td id="phoneNumber">${artistData.phoneNumber}</td>
  <td id="address">${artistData.address}</td>
  <td id="rate">${artistData.rate}</td>
  <td><button id="update-artist" onClick="handleUpdate()">Update</button></td>
</tr>
`
}

