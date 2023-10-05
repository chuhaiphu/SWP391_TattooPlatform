package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Artist")

public class Artist {
    @Id
    @Column(name = "artist_email")
    private String artistEmail;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "rate")
    private float rate;

    @Column(name = "studio_Manager_email")
    private String studioManagerEmail;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)

    private Collection<Artist_Certificate> artist_Certificates;
}
