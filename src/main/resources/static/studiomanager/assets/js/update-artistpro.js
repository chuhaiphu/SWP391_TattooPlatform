$(document).ready(function () {
    const Artist = JSON.parse(sessionStorage.getItem('Artist'));
    document.getElementById('emailArtist').value = Artist.email;
    document.getElementById('updateNameArtist').value = Artist.fullname;
    document.getElementById('updateAddressArtist').value = Artist.phonenumber;
    document.getElementById('updatePhoneArtist').value = Artist.address;
    $("#update-artist").click(function () {

        // Get the values from input fields
        var email = $("#emailArtist").val();
        var fullName = $("#updateNameArtist").val();
        var phoneNumber = $("#updatePhoneArtist").val();
        var address = $("#updateAddressArtist").val();

        // Create a data object to send via AJAX
        var data = {
            email: email,
            fullName: fullName,
            phoneNumber: phoneNumber,
            address: address
        };

        // Send an AJAX POST request to update the artist
        $.ajax({
            type: "PUT",
            url: "/view-artist/update-artist/" + email, // Replace with the actual API endpoint
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(data),
            success: function (data) {
                // Handle the success response
                console.log("Artist updated successfully:", data);

                // Optionally, you can display a success message and redirect the user.
                // For example, you can redirect back to the artist list page:
                window.location.href = "view-artist.html";
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error updating artist: " + error);

                // Optionally, you can display an error message to the user.
            }
        });
    });
});

