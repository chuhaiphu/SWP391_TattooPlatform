    //
    // $(document).ready(function () {
    //     // Select the form by its class
    //     var form = $('form');
    //     // Attach an event listener to the form submit
    //     form.submit(function (event) {
    //         event.preventDefault();
    //         // Serialize the form data
    //         var formData = form.serialize();
    //
    //         // Send an AJAX request
    //         $.ajax({
    //             type: "POST", // Use POST method
    //             url: "", // Replace with your REST endpoint URL
    //             data: formData, // Form data
    //             success: function (response) {
    //                 var tattooLoverEmail = form.find('[name="email"]').val();
    //                 $.ajax({
    //                     type: "GET",
    //                     url: "/tattoolovers/" + tattooLoverEmail, // Replace with your REST endpoint URL
    //                     success: function (userData) {
    //                         const tattooLover = userData; // Assuming your API returns the tattooLover object
    //                         sessionStorage.setItem('tattooLover', JSON.stringify(tattooLover));
    //
    //                     },
    //                     error: function (xhr, status, error) {
    //                         // Handle errors here
    //                         // You can display an error message to the user
    //                         console.error('Error:', error);
    //                     }
    //                 });
    //                 if (response === "lovers") {
    //                     window.location.href = "/service";
    //                 } else if (response === "AdminLogin") {
    //                     window.location.href = "/admin-page.html";
    //                 } else {
    //                     // Handle other responses as needed
    //                 }
    //             },
    //             error: function (xhr, status, error) {
    //                 // Handle errors here
    //                 // You can display an error message to the user
    //                 console.error('Error:', error);
    //             }
    //         });
    //     });
    // });

    $(document).ready(function () {
        const form = $('form');

        form.submit(async function (event) {
            event.preventDefault();
            const formData = form.serialize();

            try {
                const response = await $.ajax({
                    type: "POST",
                    url: "", // Replace with your REST endpoint URL
                    data: formData
                });

                const tattooLoverEmail = form.find('[name="email"]').val();
                const userData = await $.ajax({
                    type: "GET",
                    url: "/tattoolovers/" + tattooLoverEmail
                });

                const tattooLover = userData;
                sessionStorage.setItem('tattooLover', JSON.stringify(tattooLover));

                if (response === "lovers") {
                    window.location.href = "/service";
                } else if (response === "AdminLogin") {
                    window.location.href = "/admin-page.html";
                } else {
                    // Handle other responses as needed
                }
            } catch (error) {
                console.error('Error:', error);
            }
        });
    });

    document.addEventListener("DOMContentLoaded", function() {
        const loginStatus = document.getElementById("loginStatus");

        // Check if a user is logged in
        const tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
        if (tattooLover && tattooLover.content.username) {
            // User is logged in, update the content to show the user's name
            loginStatus.innerHTML = `Welcome, ${tattooLover.content.username}`
            loginStatus.href = "/tattoolovers";
        }
    });