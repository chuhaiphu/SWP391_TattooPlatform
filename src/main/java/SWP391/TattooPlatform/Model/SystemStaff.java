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
public class SystemStaff {

    @Id
    private String system_Staff_email;

    private String username;

    private String password;

    private String full_name;

    private String phone_number;

    private String address;

    private String roleID;

    private String admin_email;

    @OneToMany(mappedBy = "systemStaff", cascade = CascadeType.ALL)
    private Collection<Studio_Tattoo_Manager> studioTattooManagers;
}
