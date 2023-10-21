
    $(document).ready(function () {
        // Select the form by its class
        var form = $('form');
        // Attach an event listener to the form submit
        form.submit(function (event) {
            event.preventDefault();
            // Serialize the form data
            var formData = form.serialize();

            // Send an AJAX request
            $.ajax({
                type: "POST", // Use POST method
                url: "", // Replace with your REST endpoint URL
                data: formData, // Form data
                success: function (response) {
                    // Handle a successful response from the server
                    // You can redirect the user or show a success message
                    //console.log('Login successful');
                    if (response === "UserLogin") {
                        window.location.href = "/service-list.html";
                    } else if (response === "AdminLogin") {
                        window.location.href = "/admin-page.html";
                    } else {
                        // Handle other responses as needed
                    }
                },
                error: function (xhr, status, error) {
                    // Handle errors here
                    // You can display an error message to the user
                    console.error('Error:', error);
                }
            });
        });
    });

