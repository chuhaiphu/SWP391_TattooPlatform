package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Artist")
public class Artist {
    @Id
    @Column (name = "artist_email")
    private String email;
    @Column (name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "rate")
    private float rate;
    @Column(name = "studio_Manager_email")
    private String studioManagerEmail;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    // mappedBy trỏ tới tên biến artist ở trong Role.
    @ManyToMany(mappedBy = "artist")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @EqualsAndHashCode.Exclude

    private Collection<Role> role;

}
