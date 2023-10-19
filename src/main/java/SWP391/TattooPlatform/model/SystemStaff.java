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

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "statusID")
    private String statusID;

    @JsonIgnore
    @OneToMany(mappedBy = "systemStaff", cascade = CascadeType.ALL)
    private Collection<Studio_Tattoo_Manager> studioTattooManagers;

    @JsonIgnore
    @OneToMany(mappedBy = "systemStaff", cascade = CascadeType.ALL)
    private Collection<Post> posts;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "status_ID", insertable = false, updatable = false)
    private UserStatus userStatus;


}
