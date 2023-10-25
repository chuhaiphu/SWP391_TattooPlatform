document.addEventListener('DOMContentLoaded', function () {
    // Get references to the input and output elements
    const inputDate = document.querySelector('.ser-date');
    const outputDate = document.getElementById('output_date');
    const inputSlot = document.querySelector('.ser-time');
    const outputSlot = document.getElementById('output_time');
    const inputName = document.getElementById('input_full_name');
    const outputName = document.getElementById('output_full_name');
    const inputEmail = document.getElementById('input_email');
    const outputEmail = document.getElementById('output_email');
    const inputPhone = document.getElementById('input_phone');
    const outputPhone = document.getElementById('output_phone');
    const inputAddress = document.getElementById('input_address');
    const outputAddress = document.getElementById('output_address');
    const outputServiceName = document.getElementById('serviceName');
    const outputStudioName = document.getElementById('studioName');
    var selectedServiceName = sessionStorage.getItem('selectedServiceName');
    var selectedStudioName = sessionStorage.getItem('selectedStudioName');
    //Get slot by date of studio
    inputDate.addEventListener('change', function () {
        var selectedDate = $(this).val();
        fetchSlots(selectedDate); // Call the function to fetch slots for the selected date
    });
    function fetchSlots(selectedDate) {
        //Perform AJAX request to fetch slots based on the selected date
        //Example:
        $.ajax({
            url: "/slot/allSlot/" + selectedDate,
            type: "GET",
            data: 'json',
            success: function(data) {
                // Update the time slots in the UI
                updateSlotsUI(data);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("Error: " + errorThrown);
            }
        });
        updateSlotsUI(data);
    }

    function updateSlotsUI(slots) {
        timeSlotsSelect.innerHTML = ''; // Clear the existing options

        // Add the retrieved slots to the combobox
        slots.forEach(function (slot) {
            var option = document.createElement('option');
            option.text = slot;
            timeSlotsSelect.add(option);
        });
    }
    // Get reference to the "Next" button
    const nextButton1 = document.getElementById('next_date_hour');
    const nextButton2 = document.getElementById('next_info');

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
        outputServiceName.value = selectedServiceName;
        outputStudioName.value = selectedStudioName;
    });

});