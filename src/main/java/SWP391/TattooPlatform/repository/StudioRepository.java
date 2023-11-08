package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Studio;
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
public interface StudioRepository extends JpaRepository<Studio, String> {

    List<Studio> findAll();

    Studio findStudioByStudioID(String id);


    Studio findStudioByManagerEmail(String managerEmail);
    List<Studio> findStudiosByStudioName(String studioName);
    Studio findStudioByStudioName(String studioName);
    Studio save(Studio studio);



    @Modifying
    @Transactional
    @Query("UPDATE Studio s set s.studioName = :studioName," +
            "s.address = :address," +
            "s.district = :district," +
            "s.bannerImg = :bannerImg," +
            "s.briefInfo = :briefInf," +
            "s.content = :content where  s.studioID = :studioID")
    void updateStudioByStudioID(@Param("studioID") String studioID,
                                @Param("studioName") String studioName,
                                @Param("address") String address,
                                @Param("district") String district,
                                @Param("bannerImg") String bannerImg,
                                @Param("briefInf") String briefInf,
                                @Param("content") String content
                              );



}
