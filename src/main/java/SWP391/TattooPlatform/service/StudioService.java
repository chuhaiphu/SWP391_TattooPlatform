package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.ResponseStudioService;
import SWP391.TattooPlatform.model.Studio;
import SWP391.TattooPlatform.model.Studio_Tattoo_Manager;
import SWP391.TattooPlatform.repository.StudioRepository;
import SWP391.TattooPlatform.repository.Studio_Tattoo_ManagerRepository;
import SWP391.TattooPlatform.repository.TattooServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudioService {
    final StudioRepository studioRepository ;

    final TattooServiceRepository tattooServiceRepository;

    final Studio_Tattoo_ManagerRepository studioTattooManagerRepository;
    public StudioService(StudioRepository studioRepository,
                         TattooServiceRepository tattooServiceRepository,
                         Studio_Tattoo_ManagerRepository studioTattooManagerRepository) {
        this.studioRepository = studioRepository;
        this.tattooServiceRepository  =  tattooServiceRepository;
        this.studioTattooManagerRepository = studioTattooManagerRepository;
    }

    public ResponseEntity<?> findAllStudio() {
        List<Studio> studioList = studioRepository.findAll();
        if(studioList.isEmpty()) {
            return ResponseUtils.error("not any studio here", HttpStatus.OK);
        }
        return ResponseUtils.get(studioList,HttpStatus.OK);
    }
    public List<Studio> getStudioList() {
        if(studioRepository.findAll().isEmpty()) return null;
        return studioRepository.findAll();
    }
    public Studio findStudioByStudioID(String id){
        return studioRepository.findStudioByStudioID(id);
    }
    public ResponseEntity<?> findStudioByID(String id) {
        Studio studio = studioRepository.findStudioByStudioID(id);
        List<SWP391.TattooPlatform.model.Service> list = new ArrayList<>();

        for(SWP391.TattooPlatform.model.Service service : studio.getStudioTattooManager().getServices()) {
            list.add(service);
        }

        return ResponseUtils.get(new ResponseStudioService(studio,list),HttpStatus.OK);
    }

//    public List<Studio> getStudioByServiceNameList(String name) {
//
//        List<Studio> allStudio = studioRepository.findAll();
//
//        List<Studio> studioList = new ArrayList<>();
//
//
//        for(Studio studio : allStudio) {
//            for(SWP391.TattooPlatform.model.Service service : studio.getStudioTattooManager().getServices()) {
//                if(service.getServiceName().trim().contains(name.trim())) {
//                    studioList.add(studio);
//                }
//            }
//        }
//        if(studioList.isEmpty()) {
//            return Collections.emptyList();
//        }
//        return studioList;
//    }
    public ResponseEntity<?> findStudioByServiceName(String name) {

        List<Studio> allStudio = studioRepository.findAll();

        List<Studio> studioList = new ArrayList<>();


        for(Studio studio : allStudio) {
            for(SWP391.TattooPlatform.model.Service service : studio.getStudioTattooManager().getServices()) {
                if(service.getServiceName().trim().contains(name.trim())) {
                    studioList.add(studio);
                }
            }
        }
        if(studioList.isEmpty()) {
            return ResponseUtils.error("Can not found any studio",HttpStatus.OK);
        }
        return ResponseUtils.get(studioList,HttpStatus.OK);
    }

//    public ResponseEntity<?> findAllStudioByStudioName(String studioName) {
//        List<Studio> studioList = studioRepository.findStudiosByStudioName(studioName);
//        if(studioName == null) {
//            return ResponseUtils.get(studioRepository.findAll(),HttpStatus.OK);
//        }
//        return ResponseUtils.get(studioList,HttpStatus.OK);
//    }
    public ResponseEntity<?> findStudioByStudioName(String name) {
        List<Studio> studioList = studioRepository.findAll();
        List<Studio> searchList = new ArrayList<>();
        for(Studio studio : studioList) {
            if(studio.getStudioName().contains(name)) {
                searchList.add(studio);
            }
        }

        if(name.equals("")) {
            return   ResponseUtils.get( studioRepository.findAll(), HttpStatus.OK);
        }
            return   ResponseUtils.get(searchList, HttpStatus.OK);

    }
}
