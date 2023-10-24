
class Artist {
    constructor(email, fullName, phoneNumber, address,rate, username,password ) {
        this.email= email;
        this.fullname = fullName;
        this.phoneNumber =phoneNumber;
        this.address = address;
        this.rate = rate;
        this.username = username;
        this.password = password;
    }
}

function handleUpdate() {
    let email = document.getElementById('email').textContent
    let fullname = document.getElementById('fullName').textContent
    let username = document.getElementById('username').textContent
    let password = document.getElementById('password').textContent
    let phoneNumber = document.getElementById('phoneNumber').textContent
    let address = document.getElementById('address').textContent
    let rate = document.getElementById('rate').textContent

    let artist = new Artist(email, fullname, phoneNumber, address, rate, username, password );

    sessionStorage.setItem('Artist', JSON.stringify(artist));
    window.location.href = "/update-artist.html";

}


/*document.getElementById("update-artist").addEventListener("click", function () {
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

});*/














