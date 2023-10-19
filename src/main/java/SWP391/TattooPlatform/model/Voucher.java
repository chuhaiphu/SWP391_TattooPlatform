package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


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
    @Column(name = "star_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "description")
    private String description;
    @Column(name = "manager_email")
    private String managerEmail;
}