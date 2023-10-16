package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToMany(mappedBy = "BookingStatuses")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<BookingDetail> bookingDetails;

}
