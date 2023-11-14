package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "service_ID",length = 15,updatable = false,nullable = false )
    private String serviceID;

    @Column(name = "service_name")
    @Size(min = 1, max = 20, message = "Service must have length between {min} and {max}")
    private String serviceName;

    @Size(min = 1, max = 500, message = "Description must have length between {min} and {max}")
    @Column(name = "description")
    private String description ;


    @Column(name = "price")
    private float price;

    @Size(min = 1, max = 250, message = "Image link must have length between {min} and {max}")
    @Column(name = "link_image")
    private String linkImage;

    @Column(name = "tattoo_Manager_email")
    private String tattooManagerEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tattoo_Manager_email", insertable=false, updatable=false)
    private Studio_Tattoo_Manager studioTattooManager;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    private Set<BookingDetail> bookingDetails;




}
