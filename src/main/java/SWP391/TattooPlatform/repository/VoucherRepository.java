package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    //SEARCH
    List<Voucher> findAll();
    List<Voucher> findAllByStartDate(String date);
    List<Voucher> findAllByEndDate(String date);
    Voucher findVoucherByVoucherID(String voucherID);

    //INSERT
    Voucher save(Voucher voucher);


}
