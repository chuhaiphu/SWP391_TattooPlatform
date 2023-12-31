package SWP391.TattooPlatform.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Post")
public class   Post {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "postID")
    private String postID;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "thumbnail_link")
    private String thumbnailLink;

    @Column(name = "description")
    private String description;

    @Column(name = "brief_info")
    private String briefInfo;

    @Column(name = "status")
    private String status;

    @Column(name = "system_Staff_email")
    private String systemStaffEmail;

    @Column(name = "manager_email")
    private String managerEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_email", insertable = false, updatable = false)
    private Studio_Tattoo_Manager studioTattooManager;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "system_Staff_email", insertable = false, updatable = false)
    private SystemStaff systemStaff;
}
