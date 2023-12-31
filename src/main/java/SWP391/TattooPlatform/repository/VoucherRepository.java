package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Voucher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
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
    Voucher findVoucherByVoucherName(String voucherName);

    //INSERT
    Voucher save(Voucher voucher);

    @Modifying
    @Transactional
    @Query(value = "delete from Voucher v where v.voucherID = :voucherID")
    void deleteVoucher(@Param("voucherID") String voucherID);

}
