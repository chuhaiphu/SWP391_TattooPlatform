document.addEventListener('DOMContentLoaded', function () {
    // Get references to the input and output elements
    const password = document.getElementById('password');
    const confirm_password = document.getElementById('confirm_password');

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


});

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
    // Reset the form and hide the Cancel button
    document.getElementById("form_info").reset();
    document.getElementById("full_name").readOnly = true;
    document.getElementById("username").readOnly = true;
    document.getElementById("address").readOnly = true;
    document.getElementById("phone").readOnly = true;

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

