package SWP391.TattooPlatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Studio")
public class Studio {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "studio_ID",length = 15,updatable = false,nullable = false )
    private String studioID;

    @Column(name = "studio_name")
    private String studioName;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "banner_Img")
    private String bannerImg;

    @Column(name = "brief_Info")
    private String briefInfo;

    @Column(name = "content")
    private String content;

    @Column(name = "manager_email")
    private String managerEmail;

    @OneToOne
    @JoinColumn(name = "manager_email",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Studio_Tattoo_Manager studioTattooManager;

    @OneToMany(mappedBy = "studio")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Slot> slots ;

}
