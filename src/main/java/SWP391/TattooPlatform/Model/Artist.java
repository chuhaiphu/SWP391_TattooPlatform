package SWP391.TattooPlatform.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Artist {
    @Id
    private String artist_email;

    private String full_name;

    private String phone_number;

    private String address;

    private float rate;

    private String roleID;

    private String studio_Manager_email;

    private String username;

    private String password;
    @OneToMany(mappedBy = "Artist", cascade = CascadeType.ALL)

    private Collection<Artist_Certificate> artist_Certificates;
}
