package SWP391.TattooPlatform.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Studio_Certificate {
    @Id
    private String studio_Certificate_ID;

    private String studio_Certificate_name;

    private String description;

    private String studio_Manager_email;

    @ManyToOne
    @JoinColumn(name = "studio_Manager_email")

    private Studio_Tattoo_Manager studio_Tattoo_Manager;
}
