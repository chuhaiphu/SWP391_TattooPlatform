class Voucher {
    constructor(voucherID, voucherName, discount, startDate,endDate, description,managerEmail ) {
        this.voucherID= voucherID;
        this.voucherName = voucherName;
        this.discount =discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.managerEmail = managerEmail;
    }
}

function handleUpdate(voucherId) {
    let voucherID = document.querySelector(`.voucherID[data-voucher-id="${voucherId}"]`).textContent;
    let voucherName = document.querySelector(`.voucherName[data-voucher-id="${voucherId}"]`).textContent;
    let discount = document.querySelector(`.discount[data-voucher-id="${voucherId}"]`).textContent;
    let startDate = document.querySelector(`.startDate[data-voucher-id="${voucherId}"]`).textContent;
    let endDate = document.querySelector(`.endDate[data-voucher-id="${voucherId}"]`).textContent;
    let description = document.querySelector(`.description[data-voucher-id="${voucherId}"]`).textContent;
    let managerEmail = document.querySelector(`.managerEmail[data-voucher-id="${voucherId}"]`).textContent;

    let voucher = new Voucher(voucherID, voucherName, discount, startDate, endDate, description, managerEmail );

    sessionStorage.setItem('Voucher', JSON.stringify(voucher));
    window.location.href = "/update-voucher.html";

}