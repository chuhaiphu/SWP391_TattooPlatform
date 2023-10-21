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
@Table(name = "admin")
public class Admin {
    @Id
    private String adminEmail;


    private String username;


    private String password;




//    @JsonIgnore
//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
//    private Collection<Post> posts;
}
