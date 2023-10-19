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
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "slot_ID",length = 15,updatable = false,nullable = false )
    private String slotID;

    @Column(name = "studio_ID")
    private String studioID;

    @Column(name = "start_time")
    private String startTime;

    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<BookingDetail> bookingDetails;

    @ManyToOne
    @JoinColumn(name = "studio_ID",insertable = false,updatable = false   )
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private Studio studio;
}
