
class Artist {
    constructor(email, fullName, phoneNumber, address,rate, username,password ) {
        this.email= email;
        this.fullname = fullname;
        this.phoneNumber =phoneNumber;
        this.address = address;
        this.rate = rate;
        this.username = username;
        this.password = password;
    }
}


document.getElementById("update-artist").addEventListener("click", function () {
    // Enable input fields
    let email = document.getElementById('email').value
    let fullname = document.getElementById('fullName').value
    let username = document.getElementById('username').value
    let password = document.getElementById('password').value
    let phoneNumber = document.getElementById('phoneNumber').value
    let address = document.getElementById('address').value
    let rate = document.getElementById('rate').value

    let Artist = new Artist(email, fullname, phoneNumber, address, rate, username, password );

    sessionStorage.setItem('Artist', JSON.stringify(Artist));
    window.location.href = "/update-artist.html";

});














