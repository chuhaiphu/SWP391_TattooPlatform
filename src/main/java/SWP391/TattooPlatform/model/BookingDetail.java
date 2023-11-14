package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
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

    @Column(name = "service_ID")
    private String serviceID;

    @Column(name = "artist_email")
    private String artistEmail;

    @Column(name = "voucherID")
    private String voucherID;

    @Column(name = "price")
    private float price;

    @Column(name = "status_ID")
    private String statusID;

    @Column(name = "slot_ID")
    private String slotID;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_ID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "slot_ID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Slot slot;

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
    private Service service;


    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "artist_email", insertable = false, updatable = false)
    private Artist artist;

    @JsonIgnore
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "voucherID", insertable = false, updatable = false)
    private Voucher voucher;
}
