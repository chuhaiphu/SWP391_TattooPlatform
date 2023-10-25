
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

function handleUpdate(artistId) {
    let email = document.querySelector(`.email[data-artist-id="${artistId}"]`).textContent;
    let fullname = document.querySelector(`.fullName[data-artist-id="${artistId}"]`).textContent;
    let username = document.querySelector(`.username[data-artist-id="${artistId}"]`).textContent;
    let password = document.querySelector(`.password[data-artist-id="${artistId}"]`).textContent;
    let phoneNumber = document.querySelector(`.phoneNumber[data-artist-id="${artistId}"]`).textContent;
    let address = document.querySelector(`.address[data-artist-id="${artistId}"]`).textContent;
    let rate = document.querySelector(`.rate[data-artist-id="${artistId}"]`).textContent;

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














