
$(document).ready(function () {
    let counter = 1;
    var cart = JSON.parse(localStorage.getItem('cart')); // Store the updated cart in local storage
    console.log(cart);
    const tbody = document.querySelector('.cart-tble tbody');
    // Clear previous contents of the table
    tbody.innerHTML = '';
    // Populate the table with cart items
    if (cart.length === 0) {
        const row = document.createElement('tr');
        row.innerHTML = `<span class="empty-cart-message">Cart is empty</span>`;
        tbody.appendChild(row);
    } else {
        cart.forEach(service => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td data-label="Index">${counter}</td>
                </td>
                <td data-label="Image">
                    <a href="view-studio.html" class="pro-img-cart">
                        <img src="${service.serviceImg}}">
                    </a>
                </td> 
                <td data-label="Name">
                    <a href="view-studio.html">
                        ${service.serviceName}
                    </a>
                </td>
                <td data-label="Studio">
                    ${service.studioName}
                </td>
                <td data-label="Price"> 
                    ${service.servicePrice}
                </td>
                <td data-label=""> 
                    <a href="#" class="remove-btn" data-index="${counter - 1}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                        <path d="M3.5 5.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5V6h-9v-.5zM2 6a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1H2z"/>
                        <path fill-rule="evenodd" d="M.879 1.243a.5.5 0 0 1 .121-.657l1-1a.5.5 0 0 1 .658.083l1.5 2a.5.5 0 0 1 .075.192L4.414 4H11.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H4.414l.5.5H12a.5.5 0 0 1 0 1H4.914l.5.5H12a.5.5 0 0 1 0 1H4.914l.5.5H12a.5.5 0 0 1 0 1H4.914l.5.5H12a.5.5 0 0 1 0 1H6.414l-.5.5H13.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V1.757a.5.5 0 0 1 .879-.514L1.879 3.243l-.9-1a.5.5 0 0 1-.1-.657z"/>
                    </svg>
                    </a>
                </td>
            `;
            tbody.appendChild(row);
            counter++;
        });
        const totalElement = document.getElementById('total-price');
        const totalPrice = calculateTotalPrice(cart);
        console.log(totalPrice);
        totalElement.innerText = `${totalPrice}$`;
    }

    $(document).on('click', '.appointment-btn', function () {
        var confirmation = confirm("You are proceeding to appointment. Do you want to continue?")
        if(confirmation){
            window.location.href = "appointment-page.html"
        }
    });
    $(document).on('click', '.remove-btn', function () {
        var index = $(this).data('index');
        var confirmation = confirm("Are you sure you want to remove this item from the cart?");
        if (confirmation) {
            cart.splice(index, 1);
            localStorage.setItem('cart', JSON.stringify(cart));
            location.reload(); // Reload the page to reflect the changes
        }
    });
});
function calculateTotalPrice(cart) {
    let totalPrice = 0;
    for (let i = 0; i < cart.length; i++) {
        totalPrice += parseFloat(cart[i].servicePrice);
    }
    return totalPrice;
}