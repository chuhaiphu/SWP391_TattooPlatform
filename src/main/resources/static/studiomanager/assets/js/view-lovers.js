$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/tattoolovers/view-list", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var lover of data) {
                renderloverData(lover);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function renderloverData(loverdata) {
    var loverTable = $("#loverList_template").html();
    loverTable = loverTable.replace("{{tattooLoveremail}}", loverdata.tattooLoveremail );
    loverTable = loverTable.replace("{{fullname}}", loverdata.fullname );
    loverTable = loverTable.replace("{{username}}", loverdata.username );
    loverTable = loverTable.replace("{{password}}", loverdata.password );
    loverTable = loverTable.replace("{{phonenumber}}", loverdata.phonenumber );
    loverTable = loverTable.replace("{{address}}", loverdata.address );
    loverTable = loverTable.replace("{{statusID}}", loverdata.statusID );



    var added_lover = $("#lover");
    $(loverTable).appendTo(added_lover);

}
