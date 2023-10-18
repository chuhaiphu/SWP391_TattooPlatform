package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking_Detail")
public class BookingDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "booking_Detail_ID",length = 15,updatable = false,nullable = false)
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

    @Column(name = "statusID")
    private String statusID;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "booking_ID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "service_ID", insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private Service services;




}
