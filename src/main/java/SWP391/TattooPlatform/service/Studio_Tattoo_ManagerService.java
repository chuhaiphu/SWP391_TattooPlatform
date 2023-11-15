package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
import SWP391.TattooPlatform.repository.Studio_Tattoo_ManagerRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studio_Tattoo_ManagerService {
    final Studio_Tattoo_ManagerRepository studioTattooManagerRepository;
    public Studio_Tattoo_ManagerService(Studio_Tattoo_ManagerRepository studioTattooManagerRepository) {
        this.studioTattooManagerRepository = studioTattooManagerRepository;
    }

    public List<Studio_Tattoo_Manager> getManagerList() {
        if(studioTattooManagerRepository.findAll().isEmpty()) {
            return null;
        }
        return studioTattooManagerRepository.findAll();
    }

    public ResponseEntity<?> getManagerByEmail(String email) {
        Studio_Tattoo_Manager s = studioTattooManagerRepository.findStudio_Tattoo_ManagerByStudioManagerEmail(email);
        if(s == null) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        return ResponseUtils.get(s, HttpStatus.OK);
    }

    public Studio_Tattoo_Manager addStudioTattooManager(Studio_Tattoo_Manager manager) {
        return studioTattooManagerRepository.save(manager);
    }

    public Studio_Tattoo_Manager updateStudioTattooManager(String managerEmail,
                                                           String newFullName,
                                                           String newPhoneNumber,
                                                           String newStatusID,
                                                           String newSystemStaffEmail,
                                                           String newUsername,
                                                           String newPassword,
                                                           String statusID)throws Exception{
        studioTattooManagerRepository.updateStudio_Tattoo_ManagerInfo(managerEmail, newFullName, newPhoneNumber, newStatusID, newSystemStaffEmail, newUsername, newPassword,statusID);
        return studioTattooManagerRepository.findStudio_Tattoo_ManagerByStudioManagerEmail(managerEmail);
    }

    public Studio_Tattoo_Manager deleteStudioTattooManager(String email) throws Exception{
        studioTattooManagerRepository.deleteStudio_Tattoo_ManagerByStudioManagerEmail(email);
        if(studioTattooManagerRepository.findStudio_Tattoo_ManagerByStudioManagerEmail(email)==null){
            return null;
        }
        else throw new Exception();
    }

}
