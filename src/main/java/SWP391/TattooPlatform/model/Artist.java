package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Artist")
public class Artist {
    @Id
    @Column (name = "artist_email")
    private String email;
    @Column (name = "full_name")
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "studio_Manager_email", insertable = false, updatable = false)
    private Studio_Tattoo_Manager studio_Tattoo_Manager;

}