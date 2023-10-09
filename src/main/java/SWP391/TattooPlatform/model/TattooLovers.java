package SWP391.TattooPlatform.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TattooLovers")

public class TattooLovers {
    @Id
    @Column(name = "tattoo_Lover_email")
    private String tattooLoveremail;
    @Column(name = "username")
    @Size(min = 1, max = 50, message = "Username must have length between {min} and {max}")
    private String username;
    @Column(name = "password")
    @Size(min = 6, max = 30, message = "Password must have length between {min} and {max}")
    private String password;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "phone_number")
    private String phonenumber;
    @Column(name = "address")
    private String address;
    @Column(name = "systemStaffemail")
    private String systemStaffemail;



}
