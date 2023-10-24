package SWP391.TattooPlatform.repository;
import SWP391.TattooPlatform.model.TattooLovers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TattooLoversRepository extends JpaRepository<TattooLovers,Long>{
    List<TattooLovers> findAllBy();
    TattooLovers findTattooLoversByTattooLoveremail(String tattooLoveremail);
    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE TattooLovers TL SET TL.username = :username, TL.fullname = :fullname, TL.password = :password, TL.phonenumber = :phonenumber, TL.address = :address WHERE TL.tattooLoveremail = :tattooLoveremail ")
    void updateTattooLovers(@Param("tattooLoveremail") String tattoo_Lover_email,
                            @Param("username") String username,
                            @Param("fullname") String fullname,
                            @Param("password") String password,
                            @Param("phonenumber") String phonenumber,
                            @Param("address") String address);
    @Modifying
    @Transactional
    @Query("UPDATE TattooLovers TL SET TL.username = :#{#tattooLovers.username}, TL.fullname = :#{#tattooLovers.fullname}, TL.phonenumber = :#{#tattooLovers.phonenumber}, TL.address = :#{#tattooLovers.address} WHERE TL.tattooLoveremail = :#{#tattooLovers.tattooLoveremail}")
    void updateTattooLovers(@Param("tattooLovers") TattooLovers tattooLovers);

    @Modifying
    @Transactional
    @Query("update  TattooLovers  t set t.statusID = :statusID where t.tattooLoveremail = :tattooLoveremail" )
    void updateStatusForLover(@Param("tattooLoveremail") String tattoo_Lover_email,
                              @Param("statusID") String statusID);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE from TattooLovers TL where TL.tattooLoveremail = :tattooLoveremail")
    void deleteTattooLoversByTattooLoveremail(@Param("tattooLoveremail") String tattooLoveremail);

    //INSERT
    @Transactional
    TattooLovers save(TattooLovers tattooLovers);

}
