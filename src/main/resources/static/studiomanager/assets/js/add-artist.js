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

        // Send an AJAX POST request to add the voucher
        $.ajax({
            type: "POST",
            url: "/view-artist/add-artist", // Replace with the actual API endpoint
            contentType: "application/json; charset-utf-8",
            data: JSON.stringify(artistData),
            success: function (data) {
                // Handle the success response
                console.log("Artist added successfully:", data);

                // Clear the input fields
                $("#emailArtist").val("");
                $("#nameArtist").val("");
                $("#phone").val("");
                $("#artistAddress").val("");
                $("#studioManagerEmail").val("");
                $("#username").val("");
                $("#password").val("");
                $("#statusID").val("");


                // Display a success message (you can customize this part)
                $("#successMessage").text("Service added successfully!");
                $("#successMessage").show();

                // Optionally, you can redirect the user or perform other actions.
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error adding Service: " + error);

                // Display an error message (you can customize this part)
                $("#errorMessage").text("Error adding service!");
                $("#errorMessage").show();

                // Optionally, you can provide error feedback to the user.
            }
        });
    });
});