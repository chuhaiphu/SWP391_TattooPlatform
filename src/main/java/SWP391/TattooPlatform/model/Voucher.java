package SWP391.TattooPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Voucher")
public class Voucher {
    @Id
    @Column(name = "voucher_ID")
    private String voucherID;
    @Column(name = "voucher_Name")
    private String voucherName;
    @Column(name = "star_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "description")
    private String description;
    @Column(name = "manager_email")
    private String managerEmail;
}