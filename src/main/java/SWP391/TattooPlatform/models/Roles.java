package SWP391.TattooPlatform.models;


import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import org.springframework.context.annotation.Primary;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Role")
public class Roles {
    @Id
    @Column(name = "role_ID")
    private String roleID;

    @Column(name = "role_name")
    private String roleName;



    @Override
    public String toString() {
        return "Roles{" +
                "roleID='" + roleID + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
