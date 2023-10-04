package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Artist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Long> {

    List<Artist> findAll();
    Artist findArtistByEmail(String email);

}
