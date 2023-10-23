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
@Table(name = "Voucher")
public class Voucher {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "SWP391.TattooPlatform.model.CustomUUIDGenerator"
    )
    @Column(name = "voucher_ID")
    private String voucherID;
    @Column(name = "voucher_Name")
    private String voucherName;

    @Column(name = "discount")
    private int discount;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "description")
    private String description;
    @Column(name = "manager_email")
    private String managerEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_email", insertable = false, updatable = false)
    private Studio_Tattoo_Manager studioTattooManager;

    @JsonIgnore
    @OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL)
    private Collection<BookingDetail> bookingDetails;
}