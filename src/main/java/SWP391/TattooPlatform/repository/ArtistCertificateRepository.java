package SWP391.TattooPlatform.repository;


import SWP391.TattooPlatform.model.Artist_Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ArtistCertificateRepository extends JpaRepository<Artist_Certificate, Long>{

    //VIEW
    List<Artist_Certificate> findAllBy();

    //UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Artist_Certificate c SET c.certificateName = :certificateName WHERE c.certificateID = :certificateID")
    void updateCertificate(@Param("certificateID") String certificateID, @Param("certificateName") String certificateName);

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE from Artist_Certificate c where c.certificateID = :certificateID")
    void deleteCertificatesByID(@Param("certificateID") String certificateID);

    //ADD
    Artist_Certificate save(Artist_Certificate artistCertificate);



}
