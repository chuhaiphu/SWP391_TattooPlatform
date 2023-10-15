package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
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

public interface Studio_Tattoo_ManagerRepository
                extends JpaRepository<Studio_Tattoo_Manager, Long>{

    //View
    List<Studio_Tattoo_Manager> findAll();

    //Search
    Studio_Tattoo_Manager findStudio_Tattoo_ManagerByStudioManagerEmail(String email);

    //Update
    @Modifying
    @Transactional
    @Query("UPDATE Studio_Tattoo_Manager s SET s.fullName = :newFullName, " +
            "s.phoneNumber = :newPhoneNumber, " +
            "s.address = :newAddress, " +
            "s.password = :newPassword " +
            "WHERE s.studioManagerEmail = :managerEmail")
    void updateStudio_Tattoo_ManagerInfo(@Param("managerEmail") String managerEmail,
                                         @Param("newFullName") String newFullName,
                                         @Param("newPhoneNumber") String newPhoneNumber,
                                         @Param("newAddress") String newAddress,
                                         @Param("newPassword") String newPassword);


}
