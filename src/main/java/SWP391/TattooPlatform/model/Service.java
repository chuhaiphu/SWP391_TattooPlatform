package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "service_ID")
    @Size(min = 1, max = 20, message = "Service ID must have length between {min} and {max}")
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


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JoinTable(name = "Booking_Service",
//            joinColumns = @JoinColumn(name = "service_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Booking_ID")
//    )
//    private Set<Booking> bookings;

    @ManyToMany(mappedBy = "services")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Booking> bookings;




}
