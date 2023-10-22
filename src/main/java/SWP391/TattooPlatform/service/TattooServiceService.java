package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Service;
import SWP391.TattooPlatform.repository.TattooServiceRepository;

import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class TattooServiceService {
    final TattooServiceRepository tattooServiceRepository;

    public TattooServiceService(TattooServiceRepository tattooServiceRepository) {
        this.tattooServiceRepository = tattooServiceRepository;
    }


    public List<Service> tattooServiceList() {
        if(tattooServiceRepository.findAll().isEmpty()) {
            return null;
        }
        return tattooServiceRepository.findAll();
    }
    public List<Service> findServiceByNameDistinctList() {
        if(tattooServiceRepository.findDistinctByServiceName().isEmpty()) {
            return null;
        }
        return tattooServiceRepository.findDistinctByServiceName();
    }

    public Service addService(Service s) {
        return tattooServiceRepository.save(s);
    }

    public Service updateService(String serviceID
            , String name , String description, float price, String linkImage, String email) throws Exception {

       tattooServiceRepository.updateService(serviceID,name,description,linkImage,email);
        return tattooServiceRepository.findServiceByServiceID(serviceID);
    }

    public Service deleteService(String serviceID)  throws Exception{
        tattooServiceRepository.deleteService(serviceID);
        Service ts = tattooServiceRepository.findServiceByServiceID(serviceID);
        if(ts == null) {
            return null;
        }else {
            throw new Exception();
        }

    }





}
