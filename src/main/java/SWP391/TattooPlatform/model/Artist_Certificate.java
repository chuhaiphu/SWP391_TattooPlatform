package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Artist_Certificate {
    @Id
    private String certificate_ID;

    private String certificate_name;

    private String artist_email;

    @ManyToOne
    @JoinColumn(name = "artist_email")

    private Artist Artist;
}
