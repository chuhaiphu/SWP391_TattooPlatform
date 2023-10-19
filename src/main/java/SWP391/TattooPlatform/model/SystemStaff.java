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
public class SystemStaff {

    @Id
    @Column(name = "system_Staff_email")
    private String systemStaffEmail;

    private String username;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;


    @Column(name = "admin_email")
    private String adminEmail;

    @JsonIgnore
    @OneToMany(mappedBy = "systemStaff", cascade = CascadeType.ALL)
    private Collection<Studio_Tattoo_Manager> studioTattooManagers;

//    @JsonIgnore
//    @OneToMany(mappedBy = "systemStaff", cascade = CascadeType.ALL)
//    private Collection<Post> posts;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "admin_email", insertable = false, updatable = false)
    private Admin admin;


}