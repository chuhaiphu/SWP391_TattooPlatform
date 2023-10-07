package SWP391.TattooPlatform.repository;
import SWP391.TattooPlatform.model.Role;
import SWP391.TattooPlatform.model.TattooLovers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TattooLoversRepository extends JpaRepository<TattooLovers,Long>{
    List<TattooLovers> findAllBy();
    TattooLovers findTattooLoversByTattooLoveremail(String tattooLoveremail);
    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE TattooLovers TL SET TL.password = :password, TL.phonenumber = :phonenumber, TL.address = :address WHERE TL.tattooLoveremail = :tattooLoveremail ")
    void updateTattooLovers(@Param("tattooLoveremail") String tattoo_Lover_email,
                            @Param("password") String password,
                            @Param("phonenumber") String phonenumber,
                            @Param("address") String address);
    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE from TattooLovers TL where TL.tattooLoveremail = :tattooLoveremail")
    void deleteTattooLoversByTattooLoveremail(@Param("tattooLoveremail") String tattooLoveremail);

    //INSERT
    @Transactional
    TattooLovers save(TattooLovers tattooLovers);

}
