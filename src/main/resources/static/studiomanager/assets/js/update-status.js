class Status {
    constructor(bookingDetailID, statusID) {
        this.bookingDetailID = bookingDetailID;
        this.statusID = statusID;

    }
}

function handleUpdateStatus(bookingDetailId) {
    let bookingDetailID = document.querySelector(`.bookingDetailID[data-bookingDetail-id="${bookingDetailId}"]`).textContent;
    let statusID = document.querySelector(`.statusID[data-bookingDetail-id="${bookingDetailId}"]`).textContent;

    let status = new Status(bookingDetailID, statusID);

    sessionStorage.setItem('Status', JSON.stringify(status));
    window.location.href = "/update-status.html";
}