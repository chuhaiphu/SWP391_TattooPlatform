package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Status")
public class BookingStatus {
    @Id
    @Column(name = "statusID")
    private String statusID;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "description")
    private String description;

    @FutureOrPresent(message = "Date should be future or present")
    @Column(name = "status_date")
    private String statusDate;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JoinTable(name = "Booking_Detail_Status",
//            joinColumns = @JoinColumn(name = "status_ID"),
//            inverseJoinColumns = @JoinColumn(name = "booking_Detail_ID")
//    )
//    private Set<BookingDetail> BookingDetails;
}
