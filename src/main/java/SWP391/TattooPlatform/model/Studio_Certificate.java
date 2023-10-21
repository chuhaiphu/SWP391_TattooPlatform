package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Studio_Certificate")
public class Studio_Certificate {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column (name = "studio_Certificate_ID")
    private String studioCertificateID;

    @Column(name = "studio_Certificate_name")
    private String studioCertificateName;

    private String description;

    @Column(name = "studio_Manager_Email")
    private String studioManagerEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "studio_Manager_email", insertable = false, updatable = false)
    private Studio_Tattoo_Manager studioTattooManager;
}
