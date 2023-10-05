package SWP391.TattooPlatform.model;


import jakarta.persistence.*;
import lombok.*;


import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Role")
public class Role {
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


    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JoinTable(name = "Role_Artist" ,
//            joinColumns = @JoinColumn(name = "role_ID"),
//            inverseJoinColumns = @JoinColumn (name = "artist_email")
//    )
//    private Collection<Artist> artist;


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JoinTable(name = "Role_TattooLover" ,
//            joinColumns = @JoinColumn(name = "role_ID"),
//            inverseJoinColumns = @JoinColumn (name = "tattoo_Lover_email")
//    )
//    private Collection<TattooLover> TattooLovers;

    //  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    //    @EqualsAndHashCode.Exclude
    //    @ToString.Exclude
    //    private Collection<SystemStaff> systemStaff;

    //  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    //    @EqualsAndHashCode.Exclude
    //    @ToString.Exclude
    //    private Collection<Admin> admin;


}
