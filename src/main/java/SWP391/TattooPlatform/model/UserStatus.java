package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_Status")
public class UserStatus {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "status_ID",length = 15,updatable = false,nullable = false )
    private String statusID;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end-date")
    private String endDate;

    @OneToMany(mappedBy = "userStatus", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Studio_Tattoo_Manager> studioTattooManagers ;

    @JsonIgnore
    @OneToMany(mappedBy = "userStatus", cascade = CascadeType.ALL)
    private Collection<Artist> artists;

    @JsonIgnore
    @OneToMany(mappedBy = "userStatus", cascade = CascadeType.ALL)
    private Collection<SystemStaff> systemStaffs;

    @OneToMany(mappedBy = "userStatus", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<TattooLovers> tattooLoversList;
}
