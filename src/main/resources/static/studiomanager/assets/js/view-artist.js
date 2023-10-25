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
    var artistId = artistData.username;
    added_artist.innerHTML =
        added_artist.innerHTML +
        `
  <tr>
  <td class="email" data-artist-id="${artistId}">${artistData.email}</td>
  <td class="fullName" data-artist-id="${artistId}">${artistData.fullName}</td>
  <td class="username" data-artist-id="${artistId}">${artistData.username}</td>
  <td class="password" data-artist-id="${artistId}">${artistData.password}</td>
  <td class="phoneNumber" data-artist-id="${artistId}">${artistData.phoneNumber}</td>
  <td class="address" data-artist-id="${artistId}">${artistData.address}</td>
  <td class="rate" data-artist-id="${artistId}">${artistData.rate}</td>
  <td><button onClick="handleUpdate('${artistId}')">Update</button></td>
</tr>
`
}

