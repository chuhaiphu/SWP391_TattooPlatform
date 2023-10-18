package SWP391.TattooPlatform.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Admin")
public class Admin {
    @Id
    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;


    @JsonIgnore
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Collection<SystemStaff> systemStaffs;

//    @JsonIgnore
//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
//    private Collection<Post> posts;
}
