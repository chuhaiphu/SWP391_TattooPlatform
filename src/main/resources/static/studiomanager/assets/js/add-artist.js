

$(document).ready(function () {
    $("#add-artist").click(function () {
        // Capture form data
        var artistData = {
            email: $("#emailArtist").val(),
            fullName: $("#nameArtist").val(),
            phoneNumber: $("#phone").val(),
            address: $("#artistAddress").val(),
            studioManagerEmail: $("#studioManagerEmail").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            statusID: $("#statusID").val()
        };

        // Check if the artist's email already exists
        $.ajax({
            type: "GET",
            url: "/artist/check-email/" + artistData.email, // Replace with the actual API endpoint
            success: function (emailExists) {
                // If the email exists, show an error message
                if (emailExists) {
                   alert("Email is already in use.")
                    console.log("Email is already in use.");
                    $("#emailArtist").val("");

                } else {
                    // If the email is not in use, proceed to add the artist
                    addArtist(artistData);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error checking email: " + error);
                // Handle the error (e.g., show an error message to the user)
            }
        });
    });

    // Function to add the artist
    function addArtist(artistData) {
        // Send an AJAX POST request to add the artist
        $.ajax({
            type: "POST",
            url: "/artist/add-artist", // Replace with the actual API endpoint
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(artistData),
            success: function (data) {
                // Handle the success response
                console.log("Artist added successfully:", data);
                alert("Artist added successfully!");
                window.location.href = "/artist";
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error adding Artist: " + error);

               alert("Error adding Artist");

            }
        });
    }
});
