$(document).ready(function () {
    $("#add-certificate").click(function () {
        // Capture form data
        var certificateData = {
            certificateName: $("#certificateName").val(),
            artistEmail: $("#artistEmail").val(),
        };

        // Send a GET request to check if the certificate name already exists for the given artist email
        $.ajax({
            type: "GET",
            url: "/artistCertificate/checkCertificate",
            data: {
                certificateName: certificateData.certificateName,
                artistEmail: certificateData.artistEmail,
            },
            success: function (data) {
                if (data.exists) {
                    // Certificate name already exists, show an error message
                    console.error("Certificate name already exists for the artist.");
                    alert("Error: Certificate name already exists for the artist.");
                } else {
                    // Certificate name is unique, proceed with adding the certificate
                    addCertificate(certificateData);
                }
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error checking certificate name: " + error);
                alert("Error checking certificate name.");
            }
        });
    });

    // Function to add the certificate
    function addCertificate(certificateData) {
        // Send a POST request to add the certificate
        $.ajax({
            type: "POST",
            url: "/artistCertificate/addCertificates",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(certificateData),
            success: function (data) {
                // Handle the success response
                console.log("Certificate added successfully:", data);
                alert("Certificate added successfully!");
                window.location.href = "/view-certificate.html";

                // Clear the input fields
                $("#certificateName").val("");
                $("#artistEmail").val("");
            },
            error: function (xhr, status, error) {
                // Handle the error
                console.error("Error adding Certificate: " + error);
                alert("Error adding Certificate!");

                // Display an error message (you can customize this part)
            }
        });
    }
});