package SWP391.TattooPlatform.Model;

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
    private String service_ID;

    private String service_name;

    private String description;

    private String price;

    private String link_image;

    private String tattoo_Manager_email;

    @ManyToOne
    @JoinColumn(name = "tattoo_Manager_email")
    private Studio_Tattoo_Manager studio_Tattoo_Manager;
}
