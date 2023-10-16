package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Studio_Certificate;
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
public interface Studio_CertificateRepository extends JpaRepository<Studio_Certificate,Long> {

    //View
    List<Studio_Certificate> findAll();

    //Search
    Studio_Certificate findStudio_CertificateByStudioCertificateID(String id);

    //Add
    Studio_Certificate save(Studio_Certificate certificate);

    //Update
    @Modifying
    @Transactional
    @Query("UPDATE Studio_Certificate s SET s.studioCertificateName = :newName, s.studioManagerEmail = :newEmail " +
            "WHERE s.studioCertificateID = :Id")
    void updateStudio_Certificate(@Param("newName") String newName,
                                  @Param("newEmail") String newEmail,
                                  @Param("Id") String certificateId);

    //Delete
    @Modifying
    @Transactional
    void deleteStudio_CertificateByStudioCertificateID(String id);
}
