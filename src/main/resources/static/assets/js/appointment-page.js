document.addEventListener('DOMContentLoaded', function () {
    const cart = JSON.parse(localStorage.getItem('cart'));
    // Get references to the input and output elements
    const inputDate = document.querySelector('.ser-date');
    const outputDate = document.getElementById('output_date');
    const inputSlot = document.getElementById('input_slot');
    const outputSlot = document.getElementById('output_time');
    const inputArtist = document.getElementById('input_artist');
    const outputArtist = document.getElementById('output_artist');
    const inputName = document.getElementById('input_full_name');
    const outputName = document.getElementById('output_full_name');
    const inputEmail = document.getElementById('input_email');
    const outputEmail = document.getElementById('output_email');
    const inputPhone = document.getElementById('input_phone');
    const outputPhone = document.getElementById('output_phone');
    const inputAddress = document.getElementById('input_address');
    const outputAddress = document.getElementById('output_address');
    const inputNote = document.getElementById('input_note');
    const outputNote = document.getElementById('output_note');
    const outputServiceName = document.getElementById('serviceName');
    const outputStudioName = document.getElementById('studioName');
    var selectedStudioID = cart[0].studioID;
    // var selectedServiceID = sessionStorage.getItem('selectedServiceID');
    // var selectedServiceName = sessionStorage.getItem('selectedServiceName');
    // var selectedStudioName = sessionStorage.getItem('selectedStudioName');
    // var selectedServicePrice = sessionStorage.getItem('selectedServicePrice');
    var serviceNames = cart.map(function(service) {
        return service.serviceName;
    }).join(", ");
    var studioName = cart[0].studioName;
    var tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    //Get slot by date of studio
    inputDate.addEventListener('change', function () {
        var selectedDate = $(this).val();
        console.log(selectedDate);
        // fetchSlots(selectedDate, selectedStudioID); // Call the function to fetch slots for the selected date
        console.log(new Date().toISOString());
        if(selectedDate >= new Date().toISOString().split('T')[0]){
            fetchSlots(selectedDate, selectedStudioID); // Call the function to fetch slots for the selected date
        }else{
            inputSlot.innerHTML = "";
            var option = document.createElement('option');
            option.value = "";
            option.text = "Date is not valid to real-time";
            inputSlot.append(option);
        }

    });
    inputSlot.addEventListener('change', function(){
        var selectedOption = this.options[this.selectedIndex];
        var selectedSlotID = selectedOption.dataset.slotID;
        console.log(selectedOption);
        console.log(selectedSlotID);
        fetchArtist(selectedSlotID, selectedStudioID);
    })
    function fetchArtist(selectedSlotID, selectedStudioID) {
        //Perform AJAX request to fetch slots based on the selected date
        //Example:
        $.ajax({
            url: "/artist/available/" + selectedStudioID + "/" + selectedSlotID,
            type: "GET",
            data: 'json',
            success: function(data) {
                // Update the time slots in the UI
                console.log(data.content)
                updateArtistsUI(data.content);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("Error: " + errorThrown);
                // alert("There is no slot available! Please choose another date");
            }
        });
    }
    function updateArtistsUI(artists) {
        // Clear the options first
        inputArtist.innerHTML = "";

        if (artists === null) {
            // If no slots are available, add a default option with the message "No slots available"
            inputArtist.innerHTML = '<option value="" disabled selected>No artist available</option>'
        } else {
            // Add the retrieved slots to the combobox
            inputArtist.innerHTML = '<option value="" disabled selected>Choose your artist</option>'
            artists.forEach(function (artist) {
                console.log(artist.fullName);
                var option = document.createElement('option');
                option.value = artist.fullName;
                option.text = artist.fullName;
                option.dataset.artistEmail = artist.email;
                inputArtist.append(option);
            });
        }
    }
    function fetchSlots(selectedDate, selectedStudioID) {
        //Perform AJAX request to fetch slots based on the selected date
        //Example:
        $.ajax({
            url: "/slot/" + selectedStudioID + "/" + selectedDate,
            type: "GET",
            data: 'json',
            success: function(data) {
                // Update the time slots in the UI
                console.log(data)
                const customTimeSort = (a, b) => {
                    const timeA = new Date(selectedDate + " " + a.startTime);
                    const timeB = new Date(selectedDate + " " + b.startTime);
                    return timeA - timeB;
                  };
                data.content.sort(customTimeSort);
                console.log(data.content)
                updateSlotsUI(data.content);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("Error: " + errorThrown);
                // alert("There is no slot available! Please choose another date");
            }
        });
    }
    function updateSlotsUI(slots) {
        // Clear the options first
        inputSlot.innerHTML = "";
    
        if (slots.length === 0) {
            // If no slots are available, add a default option with the message "No slots available"
            inputSlot.innerHTML = '<option value="" disabled selected>No slot available</option>'
        } else {
            // Add the retrieved slots to the combobox
            inputSlot.innerHTML = '<option value="" disabled selected>Choose a slot</option>'
            slots.forEach(function (slot) {
                console.log(slot.startTime);
                var option = document.createElement('option');
                option.value = slot.startTime;
                option.text = slot.startTime;
                option.dataset.slotID = slot.slotID;
                inputSlot.append(option);
            });
        }
    }
    

    // Get reference to the "Next" button
    const nextButton1 = document.getElementById('next_date_hour');
    const nextButton2 = document.getElementById('next_info');
    const submitBtn = document.getElementById('submit-btn');
    // Add a click event listener to the "Next" button
    nextButton1.addEventListener('click', function () {
        outputDate.value = inputDate.value;
        outputSlot.value = inputSlot.value;
        outputArtist.value = inputArtist.value;
        if(outputDate.value == null && outputSlot.value == null){
            console.log("Please input your information");
        }
    });

    nextButton2.addEventListener('click', function () {
        outputName.value = inputName.value;
        outputEmail.value = inputEmail.value;
        outputPhone.value = inputPhone.value;
        outputAddress.value = inputAddress.value;
        outputNote.value = inputNote.value;
        outputServiceName.value = serviceNames;
        outputStudioName.value = studioName;
    });
    submitBtn.addEventListener('click', function() {
        var name = outputName.value;
        var email = outputEmail.value;
        var phone = outputPhone.value;
        var address = outputAddress.value;
        var loverEmail = tattooLover.content.tattooLoveremail;
        var selectedSlotOption = inputSlot.options[inputSlot.selectedIndex];
        var slotID = selectedSlotOption.dataset.slotID;
        var selectedArtistOption = inputArtist.options[inputArtist.selectedIndex];
        var artistEmail = selectedArtistOption.dataset.artistEmail;
        var statusID = "status1"
        // Prepare data to be sent

        var bookingDetails = []; // Initialize an empty array to hold the booking details

            // Loop through each service in the cart and create a corresponding booking detail
        cart.forEach(function(service) {
            var bookingDetail = {
                description: outputNote.value,
                serviceID: service.serviceID,
                artistEmail: artistEmail,
                slotID: slotID,
                price: service.servicePrice.replace(/[^\d.-]/g, ''),
                statusID: statusID
            };
            bookingDetails.push(bookingDetail); // Add the booking detail to the array
        });
        var bookingData = {
            booking: {
                // Properties of your Booking object
                // For example:
                tattooLoverEmail: loverEmail,
                customerEmail: email,
                customerName: name,
                customerPhoneNumber: phone,
                address: address
            },
            bookingDetails: bookingDetails
        };

        // Send data using AJAX
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/booking/add",
            data: JSON.stringify(bookingData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",

            success: function (response) {
                // Handle success
                console.log("Booking created successfully", response);
                // Redirect to the order summary page
                localStorage.removeItem('cart');
                window.location.href = 'order-summery.html';
            },
            error: function (error) {
                // Handle error
                console.error("Error creating booking", error);

                if (error.status === 400) {
                    console.error("Bad request. Please check your inputs.");
                } else if (error.status === 404) {
                    console.error("Resource not found. Please check your endpoint.");
                } else if (error.status === 500) {
                    console.error("Internal Server Error. Please try again later.");
                } else {
                    console.error("An unexpected error occurred. Please try again later.");
                }
                if (error.responseJSON) {
                    console.error("Server responded with:", error.responseJSON);
                }
            }
        });
    });
});