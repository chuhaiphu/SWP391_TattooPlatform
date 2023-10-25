document.addEventListener('DOMContentLoaded', function () {
    // Get references to the input and output elements

    const tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    if (tattooLover){
        document.getElementById('username').value = tattooLover.content.username;
        document.getElementById('full_name').value = tattooLover.content.fullname;
        document.getElementById('email').innerHTML = `${tattooLover.content.tattooLoveremail}`
        document.getElementById('phone').value = tattooLover.content.phonenumber;
        document.getElementById('address').value = tattooLover.content.address;
        document.getElementById('password').value = tattooLover.content.password;
        document.getElementById('confirm_password').value = tattooLover.content.password;
    }

    let tattooLoverEmail = tattooLover.content.tattooLoveremail;
    axios({
        method: 'get',
        url: `booking/list/${tattooLoverEmail}`,
    })
        .then(function (response) {
            // Handle the response if needed
            for(var booking of response.data) {
                renderBooking(booking);
            }
            console.log(response.data);
        })
        .catch(function (error) {
            // Handle any errors that occur during the request
            console.error(error);
        });

});


function renderBooking(bookingData) {

    var added_booking = document.getElementById("booking");
    console.log("30" + added_booking.innerHTML);
    var bookingId = bookingData.bookingID;
    added_booking.innerHTML =
        added_booking.innerHTML +
        `
  <tr>
  <td data-label="Booking ID" class="bookingID" data-artist-id="${bookingId}">${bookingData.bookingID}</td>
  <td data-label="Customer Email" class="fullName" data-artist-id="${bookingId}">${bookingData.customerEmail}</td>
  <td data-label="Customer Name" class="username" data-artist-id="${bookingId}">${bookingData.customerName}</td>
  <td data-label="Total Price" class="phoneNumber" data-artist-id="${bookingId}">${bookingData.totalPrice}</td>
  <td data-label="Action">
    <button onClick="handleBookingDetail('${bookingId}')">
        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" viewBox="0 0 19 19" fill="none">
                                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.50007 14.2498C12.7661 14.2498 15.0886 12.1975 16.4487 10.4883C16.9205 9.89553 16.9205 9.10415 16.4487 8.51133C15.0886 6.80214 12.7661 4.74984 9.50007 4.74984C6.23405 4.74984 3.91153 6.80214 2.5514 8.51133C2.07965 9.10415 2.07965 9.89553 2.5514 10.4883C3.91153 12.1975 6.23405 14.2498 9.50007 14.2498ZM17.6877 11.4743C18.6186 10.3044 18.6186 8.6953 17.6877 7.52542C16.2086 5.66679 13.4794 3.1665 9.50007 3.1665C5.52073 3.1665 2.79153 5.66679 1.31248 7.52542C0.381517 8.6953 0.381517 10.3044 1.31248 11.4743C2.79153 13.3329 5.52073 15.8332 9.50007 15.8332C13.4794 15.8332 16.2086 13.3329 17.6877 11.4743Z" fill="#183A40"/>
                                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M11.083 9.50016C11.083 10.3746 10.3741 11.0835 9.49967 11.0835C8.62522 11.0835 7.91634 10.3746 7.91634 9.50016C7.91634 9.47769 7.91681 9.45533 7.91774 9.43308C8.04115 9.47653 8.1739 9.50016 8.31217 9.50016C8.96801 9.50016 9.49967 8.9685 9.49967 8.31266C9.49967 8.17439 9.47604 8.04164 9.4326 7.91822C9.45484 7.9173 9.4772 7.91683 9.49967 7.91683C10.3741 7.91683 11.083 8.62571 11.083 9.50016ZM12.6663 9.50016C12.6663 11.2491 11.2486 12.6668 9.49967 12.6668C7.75077 12.6668 6.33301 11.2491 6.33301 9.50016C6.33301 7.75126 7.75077 6.3335 9.49967 6.3335C11.2486 6.3335 12.6663 7.75126 12.6663 9.50016Z" fill="#183A40"/>
        </svg>
    </button>
  </td>
</tr>
`
}

function renderBookingDetail(bookingDetailData) {

    var added_bookingDetail = document.getElementById("booking-detail_service");
    added_bookingDetail.innerHTML = added_bookingDetail.innerHTML +
        `
    <p>${bookingDetailData.service.serviceName}<br>
        ${bookingDetailData.description}<br>
        Performed by: ${bookingDetailData.artist.fullName}<br
        Price:        ${bookingDetailData.price}<br>
        Status:       ${bookingDetailData.bookingStatus.statusName}<br>
    <br>
    </p>
    
    `
}

function handleBookingDetail(bookingID) {
    document.getElementById("booking-detail_customer").innerHTML = "";
    document.getElementById("booking-detail_service").innerHTML = "";
    axios({
        method: 'get',
        url: `booking/${bookingID}`,
    })
        .then(function (response) {
            // Handle the response if needed
            let bookingData = response.data;
            console.log(bookingData);
            var added_bookingDetail = document.getElementById("booking-detail_customer");
            added_bookingDetail.innerHTML = added_bookingDetail.innerHTML +
                `
            <h5>Customer Information:</h5>
            <p>${bookingData.content.customerName}<br>
            Address: ${bookingData.content.address}<br>
            </p>
         
            <div class="link"><a>${bookingData.content.customerPhoneNumber}</a></div>
            <div class="link"><a>${bookingData.content.customerEmail}</a></div>
            `
            axios({
                method: 'get',
                url: `bookingDetail/${bookingID}`,
            })
                .then(function (response) {
                    // Handle the response if needed
                    for(var bookingDetail of response.data) {
                        renderBookingDetail(bookingDetail);
                    }
                    console.log(response.data);
                })
                .catch(function (error) {
                    // Handle any errors that occur during the request
                    console.error(error);
                });;
        })
        .catch(function (error) {
            // Handle any errors that occur during the request
            console.error(error);
        });



}

document.getElementById("updateButton").addEventListener("click", function () {
    event.preventDefault();
    // Enable input fields
    document.getElementById("full_name").readOnly = false;
    document.getElementById("username").readOnly = false;
    document.getElementById("address").readOnly = false;
    document.getElementById("phone").readOnly = false;

    document.getElementById("full_name").style.backgroundColor = "";
    document.getElementById("username").style.backgroundColor = "";
    document.getElementById("address").style.backgroundColor = "";
    document.getElementById("phone").style.backgroundColor = "";

    // Show the Cancel button
    document.getElementById("cancelButton").style.display = "initial";
    document.getElementById("confirm_updateButton").style.display = "initial";
    document.getElementById("updateButton").style.display = "none";
});

document.getElementById("cancelButton").addEventListener("click", function () {
    event.preventDefault();
    let tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    // Reset the form and hide the Cancel button
    document.getElementById("form_info").reset();
    document.getElementById("full_name").readOnly = true;
    document.getElementById("username").readOnly = true;
    document.getElementById("address").readOnly = true;
    document.getElementById("phone").readOnly = true;
    document.getElementById('username').value = tattooLover.content.username;
    document.getElementById('full_name').value = tattooLover.content.fullname;
    document.getElementById('phone').value = tattooLover.content.phonenumber;
    document.getElementById('address').value = tattooLover.content.address;

    document.getElementById("username").style.backgroundColor = "#f0f0f0";
    document.getElementById("full_name").style.backgroundColor = "#f0f0f0";
    document.getElementById("phone").style.backgroundColor = "#f0f0f0";
    document.getElementById("address").style.backgroundColor = "#f0f0f0";

    document.getElementById("cancelButton").style.display = "none";
    document.getElementById("confirm_updateButton").style.display = "none";
    document.getElementById("updateButton").style.display = "initial";

});

document.getElementById("updatePassword_btn").addEventListener("click", function () {
    event.preventDefault();
    // Enable input fields
    document.getElementById('password').readOnly = false;;
    document.getElementById('confirm_password').readOnly = false;;
    document.getElementById("password").style.backgroundColor = "";
    document.getElementById("confirm_password").style.backgroundColor = "";
    document.getElementById("confirm_updatePassword_btn").style.display = "initial";
    // Show the Cancel button
    document.getElementById("cancelPassword_btn").style.display = "initial";
    document.getElementById("updatePassword_btn").style.display = "none";
});

document.getElementById("cancelPassword_btn").addEventListener("click", function () {
    event.preventDefault();
    // Reset the form and hide the Cancel button
    document.getElementById("form_password").reset();
    document.getElementById('password').readOnly = true;;
    document.getElementById('confirm_password').readOnly = true;;
    document.getElementById("cancelPassword_btn").style.display = "none";
    document.getElementById("confirm_updatePassword_btn").style.display = "none";
    document.getElementById("password").style.backgroundColor = "#f0f0f0";
    document.getElementById("confirm_password").style.backgroundColor = "#f0f0f0";
    document.getElementById("updatePassword_btn").style.display = "initial";

});


document.getElementById("confirm_updatePassword_btn").addEventListener("click", function () {
    const tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    let tattooLoverEmail = tattooLover.content.tattooLoveremail;
    let password = document.getElementById('password').value;
    let confirm_password = document.getElementById('confirm_password').value;

    let sendRequest = true;
    if (password == "" || confirm_password == ""){
        alert('Update failed. Please fill all fields.');
        sendRequest = false;
    }

    if (password != confirm_password){
        alert('Update failed. Confirm Password must be the same as Password.');
        sendRequest = false;
    }

    event.preventDefault();
    if (sendRequest) {
            axios({
                method: 'put',
                url: `/tattoolovers/changePassword/${tattooLoverEmail}`,
                params: {
                    password: password,
                },
            })
            .then(function (response) {
                // Handle the response if needed
                if (response.data.hasErrors) {
                    alert('Update failed. Please check your input.');
                } else {
                    alert('Update successful!');
                }
                console.log(response.data);
            })
            .catch(function (error) {
                // Handle any errors that occur during the request
                console.error(error);
                alert('An error occurred during the update.');
            });
    }
    // Get the values from the input fields
    // Make a PUT request using Axios

});


document.getElementById("confirm_updateButton").addEventListener("click", function () {
    const tattooLover = JSON.parse(sessionStorage.getItem('tattooLover'));
    const updatedData = {
        tattooLoveremail: tattooLover.content.tattooLoveremail,
        username: document.getElementById('username').value,
        fullname: document.getElementById('full_name').value,
        phonenumber: document.getElementById('phone').value,
        address: document.getElementById('address').value,
        statusID: tattooLover.content.statusID
    };
    let sendRequest = true;
    if (updatedData.username == "" || updatedData.fullname == "" || updatedData.phonenumber == "" || updatedData.address == ""){
        alert('Update failed. Please fill all fields.');
        sendRequest = false;
    }

    event.preventDefault();
    if (sendRequest) {
        axios({
            method: 'put',
            url: `/tattoolovers/update`,
            data: updatedData,
        })
            .then(function (response) {
                // Handle the response if needed
                if (response.data.hasErrors) {
                    alert('Update failed. Please check your input.');
                } else {
                    alert('Update successful!');
                }
                console.log(response.data);
            })
            .catch(function (error) {
                // Handle any errors that occur during the request
                console.error(error);
                alert('An error occurred during the update.');
            });
    }
    // Get the values from the input fields
    // Make a PUT request using Axios

});

