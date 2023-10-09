package SWP391.TattooPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column (name = "booking_Detail_ID")
    private String bookingDetailID;
    @Column (name = "description")
    private String description;
    @Column (name = "rating")
    private float rating;
    @Column (name = "booking_date")
    private String bookingDate;
    @Column (name = "tattoo_Lover_Email")
    private String tattooLoverEmail;
    @Column (name = "service_ID")
    private String serviceID;
    @Column (name = "artist_email")
    private String artistEmail;
}
