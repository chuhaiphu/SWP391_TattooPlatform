package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Feedback")
public class Feedback {
    @Id
    @Column (name = "feedback_ID")
    private String feedbackID;
    @Column(name = "booking_Detail_ID")
    private String bookingDetailID;
    @Column (name = "description")
    private String description;
    @Column (name = "artist_rating")
    private float artistRating;
    @Column (name = "service_rating")
    private float serviceRating;
    @Column (name = "booking_date")
    private String bookingDate;
    @Column (name = "tattoo_Lover_Email")
    private String tattooLoverEmail;
    @Column (name = "service_ID")
    private String serviceID;
    @Column (name = "artist_email")
    private String artistEmail;

//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "booking_Detail_ID") // Liên kết với nhau qua khóa ngoại person_id
//    private BookingDetail bookingDetail;
}
