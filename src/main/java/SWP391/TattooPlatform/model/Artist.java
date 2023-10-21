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
    @Column(name = "number_of_ratings")
    private int numberOfRatings;
    @Column(name = "studio_Manager_email")
    private String studioManagerEmail;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "status_ID")
    private String statusID;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Collection<BookingDetail> bookingDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Collection<Artist_Certificate> artist_certificates;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "studio_Manager_email", insertable = false, updatable = false)
    private Studio_Tattoo_Manager studioTattooManager;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "status_ID", insertable = false, updatable = false)
    private UserStatus userStatus;

}
