var ratingValue;
document.addEventListener('DOMContentLoaded', function () {
    var studio;
    var feedback;
    var bookingDetail;
    var bookingDetailId = sessionStorage.getItem('bookingDetailId');
    var feedBackContainer = document.getElementById("feedBackContainer");
    var promises = [];

    // Fetch studio data
    promises.push(
        axios.get(`/bookingDetail/studio/${bookingDetailId}`)
            .then(response => {
                studio = response.data;
                console.log(studio);
                return studio;
            })
            .catch(error => {
                console.error('Error fetching studio:', error);
                throw error; // Rethrow the error to be caught later
            })
    );

    // Fetch feedback data
    promises.push(
        axios.get(`/feedback/${bookingDetailId}`)
            .then(response => {
                feedback = response.data;
                console.log(feedback);
                return feedback;
            })
            .catch(error => {
                console.error('Error fetching feedback:', error);
                throw error; // Rethrow the error to be caught later
            })
    );

    // Fetch bookingDetail data
    promises.push(
        axios.get(`/bookingDetail/get/${bookingDetailId}`)
            .then(response => {
                bookingDetail = response.data;
                console.log(bookingDetail);
                return bookingDetail;
            })
            .catch(error => {
                console.error('Error fetching bookingDetail:', error);
                throw error; // Rethrow the error to be caught later
            })
    );

    // Use Promise.all to wait for all promises to resolve
    Promise.all(promises)
        .then(([studio, feedback, bookingDetail]) => {
            // All promises have resolved, now you can update your container
            updateFeedbackContainer(feedBackContainer, studio, feedback, bookingDetail);

            if (feedback.content != null){
                document.getElementById("feedbackButton").style.display = "none";
                document.getElementById("feedback_description").readOnly = "true";
                document.getElementById("studio_name").innerHTML = `Review ${studio.content.studioName} feedback!`;
            }

            $("#feedbackButton").click(function () {
                var description = $("#feedback_description").val();

                if (description.length < 20 || description.length > 500) {
                    // Show a popup or alert if the length is not valid
                    alert("Feedback description must be between 20 characters and 500 characters.");
                    return; // Do not proceed with the submission
                }
                var current_feedback = {
                    bookingDetailID: bookingDetail.content.bookingDetailID,
                    description: $("#feedback_description").val(),
                    artistRating: ratingValue,
                    bookingDate: bookingDetail.content.slot.date,
                    serviceID: bookingDetail.content.service.serviceID,
                    artistEmail: bookingDetail.content.artistEmail
                };
                event.preventDefault();
                $.ajax({
                    type: "POST",
                    url: "feedback/addFeedback",
                    contentType: "application/json; charset-utf-8",
                    data: JSON.stringify(current_feedback),
                    success: function  (data) {
                        alert("We appreciate you sending us your feedback!");


                        window.location.href = "/tattoolovers";
                    },
                    error: function (xhr, status, error) {
                        alert("Error: " + error);
                    }
                });

            });
        })
        .catch(error => {
            console.error('Error:', error);
            // Handle the error if needed
        });

})

function updateFeedbackContainer(container, studio, feedback, bookingDetail) {
    // Your logic to update the container with the fetched data
    // For example:
    container.innerHTML = container.innerHTML +
        `
                <div class="container">
            <div class="section-title">
                <h2 id="studio_name"> Send ${studio.content.studioName} a feedback! </h2>
            </div>
            <div class="row">
                <div class="col-md-6 col-12 contact-left-column">
                    <div class="contact-left-inner row">
                        <ul class="col-sm-6 col-12">
                            <li>
                                <h4>Telephone:</h4>
                                <p><a href="tel:${studio.content.studioTattooManager.phoneNumber}">${studio.content.studioTattooManager.phoneNumber}</a></p>
                            </li>
                            <li>
                                <h4>Email:</h4>
                                <p><a href="mailto:${studio.content.managerEmail}">${studio.content.managerEmail}</a></p>
                            </li>
                        </ul>
                        <ul class="col-sm-6 col-12">
                            <li>
                                <h4>Address:</h4>
                                <p style="font-size: medium" class="address">${studio.content.address}</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-6 col-12 contact-right-column">
                    <div class="contact-right-inner">
                        <div>
                            <h2>Feedback for ${bookingDetail.content.service.serviceName}</h2>
                        </div>
                        <form class="contact-form">
                            <div class="row">

                                <div class="col-md-12 col-12">
                                    <div class="form-group">
                                        <label style="font-size: larger"> Description:</label>
                                        <textarea id="feedback_description" style="font-size: medium" class="form-control" name="message" placeholder="Tell us what you think!" rows="8">${feedback?.content?.description || ''}</textarea>
                                    </div>
                                </div>
                                <div class="col-md-12 col-12">
                                    <div class="form-group rating-text">
                                        <label style="font-size: larger"> Please Rate for Artist: <span style="font-weight: bold; ">${bookingDetail.content.artist.fullName}</span></label>
                                    </div>
                                </div>
                                
                                <div class="col-md-4 col-12 rating">
                                    <label>
                                        <input type="radio" name="stars" value="1" ${feedback && feedback.content && feedback.content.artistRating == '1' ? 'checked' : ''}/>
                                        <span class="icon">★</span>
                                    </label>
                                    <label>
                                        <input type="radio" name="stars" value="2" ${feedback && feedback.content && feedback.content.artistRating == '2' ? 'checked' : ''}/>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                    </label>
                                    <label>
                                        <input type="radio" name="stars" value="3" ${feedback && feedback.content && feedback.content.artistRating == '3' ? 'checked' : ''}/>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                    </label>
                                    <label>
                                        <input type="radio" name="stars" value="4" ${feedback && feedback.content && feedback.content.artistRating == '4' ? 'checked' : ''}/>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                    </label>
                                    <label>
                                        <input type="radio" name="stars" value="5" ${feedback && feedback.content && feedback.content.artistRating == '5' ? 'checked' : ''}/>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                        <span class="icon">★</span>
                                    </label>
                                </div>
                            </div>

                            <div class="form-container">
                                <div class="d-flex acc-back-btn-wrp align-items-center justify-content-end">
                                    <button id="feedbackButton" class="btn back-btn-acc" type="submit">
                                        Send Feedback
                                    </button>
                                    <button id="update_feedbackButton" class="btn back-btn-acc" type="submit" style="display: none">
                                        Update Feedback
                                    </button>
                                    <button id="save_feedbackButton" class="btn back-btn-acc" type="submit" style="display: none">
                                        Save Feedback
                                    </button>
                                    <button id="cancelButton" class="btn continue-btn" type="submit" style="display: none">
                                        Cancel
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                `
    $("input[name='stars']").change(function () {
        ratingValue = $("input[name='stars']:checked").val();
    });
}


