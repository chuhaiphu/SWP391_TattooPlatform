package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Service;
import SWP391.TattooPlatform.repository.TattooServiceRepository;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class TattooServiceService {
    final TattooServiceRepository tattooServiceRepository;

    public TattooServiceService(TattooServiceRepository tattooServiceRepository) {
        this.tattooServiceRepository = tattooServiceRepository;
    }


    public List<Service> tattooServiceList() {
            List<Service> list1 = tattooServiceRepository.findAll();
        List<Service> list = new ArrayList<>();
        boolean check;
        for(Service service : list1) {
            check = false;
            if(list.isEmpty() ) {
                list.add(service);
            }else
            {
                for (Service service1 : list) {
                    if (service1.getServiceName().trim().equals(service.getServiceName().trim())) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    list.add(service);
                }
            }
        }
        return list;
    }

    public Service addService(Service s) {
        return tattooServiceRepository.save(s);
    }

    public Service updateService(String serviceID
            , String name , String description, float price, String linkImage, String email)  {

       tattooServiceRepository.updateService(serviceID,name,description, linkImage,email, price);
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
