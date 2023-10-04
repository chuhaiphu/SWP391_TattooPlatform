package SWP391.TattooPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Artist")
public class Artist {
    @Id
    @Column
    private String artist_email;
    @Column
    private String full_name;
    @Column
    private String phone_number;
    @Column
    private String address;
    @Column
    private String rate;
    @Column
    private String studio_Manager_email;
    @Column
    private String username;
    @Column
    private String password;

}
