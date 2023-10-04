package SWP391.TattooPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Role_Artist")
public class Role_Artist {
    @Id
    @Column
    private String role_ID;
    @Id
    @Column
    private String full_name;

}
