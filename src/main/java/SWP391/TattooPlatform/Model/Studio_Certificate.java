package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Studio_Certificate")
public class Studio_Certificate {

    @Id
    @Column (name = "studio_Certificate_ID")
    private String studioCertificateID;

    @Column(name = "studio_Certificate_name")
    private String studioCertificateName;

    private String description;

    @Column(name = "studio_Manager_Email")
    private String studioManagerEmail;

    @ManyToOne
    @JoinColumn(name = "studio_Manager_email", insertable = false, updatable = false)
    private Studio_Tattoo_Manager studio_Tattoo_Manager;
}
