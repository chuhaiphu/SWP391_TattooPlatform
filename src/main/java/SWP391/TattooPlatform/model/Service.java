package SWP391.TattooPlatform.model;

import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Service")
public class Service {

    @Id
    @Column(name = "service_ID")
    private String serviceID;
    @Column(name = "service_name")
    private String serviceName;
    @Column
    private String description;
    @Column(name = "link_image")
    private String linkImage;
    @Column(name = "tattoo_Manager_email")
    private String studioTattooManager;

    @ManyToOne
    @JoinColumn(name = "tattoo_Manager_email", insertable=false, updatable=false)
    private Studio_Tattoo_Manager studio_Tattoo_Manager;
}
