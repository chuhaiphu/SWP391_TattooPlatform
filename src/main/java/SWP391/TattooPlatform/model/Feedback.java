package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "feedbak_ID",length = 15,updatable = false,nullable = false )
    private String feedbackID;

    @Column(name = "booking_Detail_ID")
    private String bookingDetailID;

    @Column(name = "description")
    private String description;

    @Column(name = "tattoo_Lover_email")
    private String tattooLoverEmail;

    @Column(name = "service_ID")
    private String serviceID;

    @Column(name = "artist_email")
    private String artistEmail;

    @Column(name = "artist_rating")
    private int artistRating;

    @Column(name = "service_rating")
    private int serviceRating;

    @Column(name = "booking_date")
    private String bookingDate;

    @ManyToOne
    @JoinColumn(name = "booking_Detail_ID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private BookingDetail bookingDetail;
}
