package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
import SWP391.TattooPlatform.repository.Studio_Tattoo_ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studio_Tattoo_ManagerService {
    final Studio_Tattoo_ManagerRepository studioTattooManagerRepository;
    public Studio_Tattoo_ManagerService(Studio_Tattoo_ManagerRepository studioTattooManagerRepository) {
        this.studioTattooManagerRepository = studioTattooManagerRepository;
    }

    public List<Studio_Tattoo_Manager> managerList() {
        if(studioTattooManagerRepository.findAll().isEmpty()) {
            return null;
        }
        return studioTattooManagerRepository.findAll();
    }

}
