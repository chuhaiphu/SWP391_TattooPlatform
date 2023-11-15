$(document).ready(function() {
    const managerUser = JSON.parse(sessionStorage.getItem('manager'));
    const artistUser = JSON.parse(sessionStorage.getItem('artist'));


    // Hide all menu items by default
    $(`.artist-menu`).hide();
    $(`.manager-menu`).hide();

    // Show menu items based on user role
    if (artistUser !== null) {
        $(`.artist-menu`).show();
    } else if (managerUser !== null) {
        $(`.manager-menu`).show();
        $(`.artist-menu`).show();
    }
});