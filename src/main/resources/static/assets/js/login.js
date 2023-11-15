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
                    url: "/login",
                    data: formData
                });

                if (response.toString() === "lovers") {
                    const tattooLoverEmail = form.find('[name="email"]').val();
                    const userData = await $.ajax({
                        type: "GET",
                        url: "/tattoolovers/" + tattooLoverEmail,
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.error('Error in GET request to /tattoolovers/', errorThrown);
                        }
                    });

                    const tattooLover = userData;
                    sessionStorage.setItem('tattooLover', JSON.stringify(tattooLover));
                    window.location.href = "/index.html";
                } else if (response.toString() === "AdminLogin") {


                    window.location.href = "/adminpage/staff.html";

                } else if (response.toString() === "artist") {
                    const artistEmail = form.find('[name="email"]').val();
                    const userData = await $.ajax({
                        type: "GET",
                        url: "/artist/" + artistEmail,
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.error('Error in GET request to /artist/', errorThrown);
                        }
                    });

                    const artist = userData;
                    sessionStorage.setItem('artist', JSON.stringify(artist));
                    window.location.href = "/view-artist.html";

                } else if (response.toString() === "studioManager") {
                    const managerEmail = form.find('[name="email"]').val();
                    const userData = await $.ajax({
                        type: "GET",
                        url: "/manager/" + managerEmail,
                        error: function (jqXHR, textStatus, errorThrown) {
                        }
                    });

                    const manager = userData;
                    sessionStorage.setItem('manager', JSON.stringify(manager));
                    window.location.href = "/view-artist.html";
                }
                else {
                    // Handle the error
                    alert(JSON.stringify(response));
                }
            } catch (error) {
                console.error('Error:', error);
            }

        });
    });

