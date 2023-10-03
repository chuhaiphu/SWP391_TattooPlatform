package SWP391.TattooPlatform.Service;

import SWP391.TattooPlatform.Repository.Studio_Tattoo_ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    Studio_Tattoo_ManagerRepository dao;
    @Autowired
    public RoleService(Studio_Tattoo_ManagerRepository dao) {
        this.dao = dao;
    }

}
