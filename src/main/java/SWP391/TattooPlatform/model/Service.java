package SWP391.TattooPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

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
    private String link_image;

    @Column(name = "tattoo_Manager_email")
    private String tattoo_Manager_email;

    // @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    //    @EqualsAndHashCode.Exclude
    //    @ToString.Exclude
    //    private Collection<Booking> booking;

    //  @ManyToOne
    //    @JoinColumn(name = "tattoo_Manager_email")
    //    @EqualsAndHashCode.Exclude
    //    @ToString.Exclude
    //    private StudioTattooManager  studioTattooManager;
}
