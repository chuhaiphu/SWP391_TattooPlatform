$(document).ready(function () {
    // Send an AJAX request to fetch artist data
    $.ajax({
        type: "GET",
        url: "/feedback/allFeedback", // Replace with the actual API endpoint
        dataType: "json",
        success: function (data) {
            for( var feedback of data.content) {
                renderFeedbackData(feedback);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching artist data: " + error);
        }
    });
});

function renderFeedbackData(FeedbackData) {
    var feedbackTable = $("#feedbackList_template").html();
    feedbackTable = feedbackTable.replace("{{feedbackID}}", FeedbackData.feedbackID );
    feedbackTable = feedbackTable.replace("{{bookingDetailID}}", FeedbackData.bookingDetailID );
    feedbackTable = feedbackTable.replace("{{description}}", FeedbackData.description );
    feedbackTable = feedbackTable.replace("{{artistRating}}", FeedbackData.artistRating );
    feedbackTable = feedbackTable.replace("{{bookingDate}}", FeedbackData.bookingDate);
    feedbackTable = feedbackTable.replace("{{serviceID}}", FeedbackData.serviceID);
    feedbackTable = feedbackTable.replace("{{artistEmail}}", FeedbackData.artistEmail);


    var added_feedback = $("#feedback");
    $(feedbackTable).appendTo(added_feedback);

}
