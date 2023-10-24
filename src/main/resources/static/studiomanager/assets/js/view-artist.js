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
    var artistTable = $("#artistList_template").html();
    artistTable = artistTable.replace("{{email}}", artistData.email );
    artistTable = artistTable.replace("{{fullName}}", artistData.fullName );
    artistTable = artistTable.replace("{{username}}", artistData.username );
    artistTable = artistTable.replace("{{password}}", artistData.password );
    artistTable = artistTable.replace("{{phoneNumber}}", artistData.phoneNumber );
    artistTable = artistTable.replace("{{address}}", artistData.address );
    artistTable = artistTable.replace("{{rate}}", artistData.rate );


    var added_artist = $("#artist");
    $(artistTable).appendTo(added_artist);

}
