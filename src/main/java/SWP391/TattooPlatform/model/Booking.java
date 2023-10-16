package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @Column(name = "Booking_ID" )
    private String bookingID;

    @Column(name = "tattoo_Lover_email")
    @Email(message = "invalid Email format")
    private String tattooLoverEmail ;

    @Column(name = "artist_email")
   // @Email(message = "invalid Email format")
    private String artistEmail;

    @Column (name = "time")
    private String time ;

    @FutureOrPresent(message = "Date should be future or present")
    @NotNull(message = "not allow emptys")
    @Column (name = "date")
    private String date;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "total_price")
    private Float totalPrice;



    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "Booking_Service",
            joinColumns = @JoinColumn(name = "Booking_ID"),
            inverseJoinColumns = @JoinColumn(name = "service_ID")
    )
    private Set<Service> services;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Collection<BookingDetail> bookingDetails;


}
