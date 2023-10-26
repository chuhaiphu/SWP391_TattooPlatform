document.addEventListener('DOMContentLoaded', function () {
    // Get references to the input and output elements
    const inputDate = document.querySelector('.ser-date');
    const outputDate = document.getElementById('output_date');
    const inputSlot = document.getElementById('input_slot');
    const outputSlot = document.getElementById('output_time');
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
    var selectedStudioID = sessionStorage.getItem('selectedStudioID');
    var selectedServiceID = sessionStorage.getItem('selectedServiceID');
    var selectedServiceName = sessionStorage.getItem('selectedServiceName');
    var selectedStudioName = sessionStorage.getItem('selectedStudioName');
    var selectedServicePrice = sessionStorage.getItem('selectedServicePrice');
    var tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    //Get slot by date of studio
    inputDate.addEventListener('change', function () {
        var selectedDate = $(this).val();
        fetchSlots(selectedDate, selectedStudioID); // Call the function to fetch slots for the selected date
    });
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
                updateSlotsUI(data);
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
            var option = document.createElement('option');
            option.value = "";
            option.text = "No slots available";
            inputSlot.append(option);
        } else {
            // Add the retrieved slots to the combobox
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
    });

    nextButton2.addEventListener('click', function () {
        outputName.value = inputName.value;
        outputEmail.value = inputEmail.value;
        outputPhone.value = inputPhone.value;
        outputAddress.value = inputAddress.value;
        outputNote.value = inputNote.value;
        outputServiceName.value = selectedServiceName;
        outputStudioName.value = selectedStudioName;
    });
    submitBtn.addEventListener('click', function() {
        var name = outputName.value;
        var email = outputEmail.value;
        var phone = outputPhone.value;
        var address = outputAddress.value;
        var description = outputNote.value;
        var serviceID = selectedServiceID;
        var price = selectedServicePrice.replace(/[^\d.-]/g, '');
        var loverEmail = tattooLover.content.tattooLoveremail;
        var selectedSlotOption = inputSlot.options[inputSlot.selectedIndex];
        var slotID = selectedSlotOption.dataset.slotID;
        var artistEmail = "artist1@example.com";
        var statusID = "status1"
        // Prepare data to be sent
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
            bookingDetails: [
                // List of your BookingDetail objects
                // For example:
                {
                    description: description,
                    serviceID: serviceID, 
                    artistEmail: artistEmail,
                    slotID: slotID,
                    price: price,
                    statusID: statusID
                }
                // Add more BookingDetail objects as needed
            ]
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