document.addEventListener('DOMContentLoaded', function () {
    // Get references to the input and output elements
    const inputDate = document.querySelector('.ser-date');
    const outputDate = document.getElementById('output_date');
    const inputTime = document.querySelector('.ser-time');
    const outputTime = document.getElementById('output_time');
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
    var selectedServiceName = localStorage.getItem('selectedService');
    var selectedStudioName = localStorage.getItem('selectedStudioName');
    // Get reference to the "Next" button
    const nextButton1 = document.getElementById('next_date_hour');
    const nextButton2 = document.getElementById('next_info');

    // Add a click event listener to the "Next" button
    nextButton1.addEventListener('click', function () {
        outputDate.value = inputDate.value;
        outputTime.value = inputTime.value;
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