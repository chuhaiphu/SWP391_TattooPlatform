package SWP391.TattooPlatform.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studio_Tattoo_Manager {

    @Id
    private String studio_Manager_email;

    private String full_name;

    private String phone_number;

    private String address;

    private String roleID;

    private String System_Staff_email;

    private String username;

    private String password;

    @OneToMany(mappedBy = "studio_Tattoo_Manager", cascade = CascadeType.ALL)
    private Collection<Studio_Certificate> certificates;
}
