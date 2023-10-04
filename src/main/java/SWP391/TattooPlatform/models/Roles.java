package SWP391.TattooPlatform.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;


import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Role")
public class Roles  {
    @Id
    @Column(name = "role_ID")
    @Size(min = 1, max = 20, message = "Role ID must have length between {min} and {max}")
    private String roleID;

    @Size(min = 3, max = 100, message = "Role name must have length between {min} and {max}")
    @Column(name = "role_name")
    private String roleName;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JoinTable(name = "Role_StudioTattooManager" ,
//            joinColumns = @JoinColumn(name = "role_ID"),
//            inverseJoinColumns = @JoinColumn (name = "studio_Manager_email")
//    )
//    private Collection<Studio_Tattoo_Manager> studioTattooManagers;


}
