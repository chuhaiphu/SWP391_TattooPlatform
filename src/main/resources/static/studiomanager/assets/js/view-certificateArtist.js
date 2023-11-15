$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/artistCertificate/allCertificates", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var certificate of data.content) {
                renderCertificateData(certificate);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching certificate data: " + error);
        }
    });
});

function renderCertificateData(certificateData) {
    var certificateTable = $("#certificateList_template").html();
    certificateTable = certificateTable.replace("{{certificateID}}", certificateData.certificateID );
    certificateTable = certificateTable.replace("{{certificateName}}", certificateData.certificateName );
    certificateTable = certificateTable.replace("{{artistEmail}}", certificateData.artistEmail );



    var added_certificate = $("#certificate");
    $(certificateTable).appendTo(added_certificate);

}
