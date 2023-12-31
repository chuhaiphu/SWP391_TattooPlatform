package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Artist;
import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
import SWP391.TattooPlatform.model.SystemStaff;
import SWP391.TattooPlatform.model.TattooLovers;
import SWP391.TattooPlatform.repository.ArtistRepository;
import SWP391.TattooPlatform.repository.Studio_Tattoo_ManagerRepository;
import SWP391.TattooPlatform.repository.SystemStaffRepository;
import SWP391.TattooPlatform.repository.TattooLoversRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    final TattooLoversRepository tattooLoversRepository;
    final Studio_Tattoo_ManagerRepository studioTattooManagerRepository;
    final ArtistRepository artistRepository;
    final SystemStaffRepository systemStaffRepository;

    public LoginService(TattooLoversRepository tattooLoversRepository, Studio_Tattoo_ManagerRepository studioTattooManagerRepository,
                        ArtistRepository artistRepository, SystemStaffRepository systemStaffRepository) {
        this.tattooLoversRepository = tattooLoversRepository;
        this.studioTattooManagerRepository = studioTattooManagerRepository;
        this.artistRepository = artistRepository;
        this.systemStaffRepository = systemStaffRepository;
    }

    public ResponseEntity<String> login(String email, String password) {
        List<TattooLovers> tattooLoversList = tattooLoversRepository.findAll();
        List<Studio_Tattoo_Manager> studioTattooManagers = studioTattooManagerRepository.findAll();
        List<Artist> artists = artistRepository.findAll();

        for(Studio_Tattoo_Manager studioTattooManager : studioTattooManagers) {
            if(studioTattooManager.getStudioManagerEmail().equals(email) && studioTattooManager.getPassword().equals(password)) {
                return  ResponseEntity.ok("studioManager");
            }
        }

        for(Artist artist : artists) {
            if(artist.getEmail().equals(email) && artist.getPassword().equals(password)) {
                return  ResponseEntity.ok("artist");
            }
        }

        for(SystemStaff systemStaff : systemStaffRepository.findAll()) {
            if(systemStaff.getSystemStaffEmail().equals(email) && systemStaff.getPassword().equals(password)) {
                return  ResponseEntity.ok("systemStaff");
            }
        }


        for(TattooLovers tattooLovers : tattooLoversList) {
            if(tattooLovers.getTattooLoveremail().equals(email) && tattooLovers.getPassword().equals(password)) {
                return ResponseEntity.ok("lovers");
            }
        }

        return ResponseEntity.ofNullable("Not find this account");
    }
}