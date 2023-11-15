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
@Table (name = "Artist_Certificate")
public class Artist_Certificate {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "certificateID")
    private String certificateID;

    @Column(name = "certificate_name")
    private String certificateName;

    @Column(name = "artist_email")
    private String artistEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "artist_email", updatable = false, insertable = false)
    private Artist artist;
}