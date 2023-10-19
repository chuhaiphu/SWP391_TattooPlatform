package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "Booking_ID",length = 15,updatable = false,nullable = false )
    private String bookingID;

    @Column(name = "tattoo_Lover_email")
    @Email(message = "invalid Email format")
    private String tattooLoverEmail ;

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

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<BookingDetail> bookingDetails;




}