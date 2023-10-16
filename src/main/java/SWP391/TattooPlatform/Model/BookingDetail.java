package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking_Detail")
public class BookingDetail {
    @Id
    @Column(name = "booking_Detail_ID")
    private String bookingDetailID;

    @Column(name = "booking_ID")
    private String bookingID;

    @Column(name = "description")
    private String description;

    @Column(name = "tattoo_Lover_email")
    private String tattooLoverEmail;

    @Column(name = "service_ID")
    private String serviceID;

    @Column(name = "artist_email")
    private String artistEmail;

    @Column(name = "voucherID")
    private String voucherID;

    @Column(name = "price")
    private float price;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "Booking_Detail_Status",
            joinColumns = @JoinColumn(name = "booking_Detail_ID"),
            inverseJoinColumns = @JoinColumn(name = "statusID")
    )
    private Set<BookingStatus> BookingStatuses;

    @ManyToOne
    @JoinColumn(name = "booking_ID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private Booking booking;
}
