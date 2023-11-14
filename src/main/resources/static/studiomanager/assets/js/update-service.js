class Service {
    constructor(serviceID, serviceName, description, price, linkImage) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.linkImage = linkImage;
    }
}

function handleUpdate(serviceId) {
    let serviceID = document.querySelector(`.serviceID[data-service-id="${serviceId}"]`).textContent;
    let serviceName = document.querySelector(`.serviceName[data-service-id="${serviceId}"]`).textContent;
    let description = document.querySelector(`.description[data-service-id="${serviceId}"]`).textContent;
    let price = document.querySelector(`.price[data-service-id="${serviceId}"]`).textContent;
    let linkImage = document.querySelector(`.linkImage[data-service-id="${serviceId}"]`).textContent;

    let service = new Service(serviceID, serviceName, description, price, linkImage);

    sessionStorage.setItem('Service', JSON.stringify(service));
    window.location.href = "/update-service.html";
}