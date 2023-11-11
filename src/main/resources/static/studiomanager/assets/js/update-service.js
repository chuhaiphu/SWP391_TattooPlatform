class Service {
    constructor(serviceID, serviceName, description, linkImage, tattooManagerEmail, price) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.description = description;
        this.linkImage = linkImage;
        this.tattooManagerEmail = tattooManagerEmail;
        this.price = price;
    }
}

function handleUpdate(serviceId) {
    let serviceID = document.querySelector(`.serviceID[data-service-id="${serviceId}"]`).textContent;
    let serviceName = document.querySelector(`.serviceName[data-service-id="${serviceId}"]`).textContent;
    let description = document.querySelector(`.description[data-service-id="${serviceId}"]`).textContent;
    // Get the linkImage from the img tag
    let linkImage = document.querySelector(`.linkImage[data-service-id="${serviceId}"] img`);
    let tattooManagerEmail = document.querySelector(`.tattooManagerEmail[data-service-id="${serviceId}"]`).textContent;
    let price = document.querySelector(`.price[data-service-id="${serviceId}"]`).textContent;

    let service = new Service(serviceID, serviceName, description, linkImage, tattooManagerEmail, price);

    sessionStorage.setItem('Artist', JSON.stringify(service));
    window.location.href = "/update-service.html";
}

