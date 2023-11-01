package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Artist;

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
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    //READ
    List<Artist> findAll();
    Artist findArtistByEmail(String email);
    @Query("SELECT a FROM Artist a JOIN Studio s ON a.studioManagerEmail = s.managerEmail WHERE a.email NOT IN (SELECT bd.artist.email FROM BookingDetail bd WHERE bd.slotID = :slotID) AND s.studioID = :studioID")
    List<Artist> findAvailableArtistsBySlotIDAndStudioID(@Param("slotID") String slotID, @Param("studioID") String studioID);
    //INSERT
    Artist save(Artist artist);
    //UPDATE
    //Update artist infomation
    @Modifying
    @Transactional
    @Query(value = "UPDATE Artist a SET a.fullName = :fullName, a.phoneNumber = :phoneNumber, a.address = :address " +
            "WHERE a.email = :email ")
    void updateArtist(@Param("email") String email, @Param("fullName") String fullName, @Param("phoneNumber") String phoneNumber,
                    @Param("address") String address);
    //update artist username and password
    @Modifying
    @Transactional
    @Query(value = "UPDATE Artist a SET a.username = :username, a.password = :password " +
            "WHERE a.email = :email ")
    void updateArtistByUsernameAndPassword(@Param("email") String email, @Param("username") String username, @Param("password") String password);
    //update artist rating
    @Modifying
    @Transactional
    @Query(value = "UPDATE Artist a SET a.rate = :rate WHERE a.email = :email")
    void updateArtistByRate(@Param("email")String email, @Param("rate")float rate);
    //DELETE
    @Modifying
    @Transactional
    @Query(value = "delete from Artist a where a.email = :email ")
    void deleteArtistByEmail(@Param("email") String email);


}
