package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Artist_Certificate")
public class Artist_Certificate {
    @Id
    @Column(name = "certificate_ID")
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