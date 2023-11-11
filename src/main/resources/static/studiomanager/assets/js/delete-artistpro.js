$(document).ready(function () {
    const Artist = JSON.parse(sessionStorage.getItem('Artist'));
    document.getElementById('emailArtist').value = Artist.email;
    document.getElementById('updateNameArtist').value = Artist.fullname;
    document.getElementById('updateAddressArtist').value = Artist.address;
    document.getElementById('updatePhoneArtist').value = Artist.phoneNumber;
    document.getElementById('updateRate').value = Artist.rate;

    // Function to delete an artist
    function deleteArtist(email) {
        $.ajax({
            type: "DELETE",
            url: "/artist/deleteArtist/" + email,
            success: function (data) {
                console.log("Artist deleted successfully:", data);
                window.location.href = "view-artist.html"; // Redirect to the artist list page
            },
            error: function (xhr, status, error) {
                console.error("Error deleting artist: " + error);
                // Optionally, display an error message to the user
            }
        });
    }

    // Event listener for the "Delete artist" button
    $("#delete-artist").click(function () {
        var email = $("#emailArtist").val();
        // Confirm before deleting
        Swal.fire({
            title: 'Are you sure?',
            text: 'You won\'t be able to revert this!',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                // If confirmed, call the deleteArtist function
                deleteArtist(email);
            }
        });
    });

    // Rest of your code...
});
