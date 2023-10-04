package SWP391.TattooPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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
    private String rate;
    @Column(name = "studio_Manager_email")
    private String studioManagerEmail;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


}
