package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column (name = "feedback_ID",length = 15)
    private String feedbackID;
    @Column(name = "booking_Detail_ID")
    private String bookingDetailID;
    @Column (name = "description")
    private String description;
    @Column (name = "artist_rating")
    private float artistRating;
    @Column (name = "booking_date")
    private String bookingDate;
    @Column (name = "service_ID")
    private String serviceID;
    @Column (name = "artist_email")
    private String artistEmail;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "booking_Detail_ID", insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private BookingDetail bookingDetail;
}
