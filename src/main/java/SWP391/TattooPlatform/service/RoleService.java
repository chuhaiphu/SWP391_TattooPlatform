package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.models.Roles;
import SWP391.TattooPlatform.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class RoleService {
    final  RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }



    public List<Roles> getListRole() {
        if(roleRepository.findAll().isEmpty()) {
            return null;
        }
        return roleRepository.findAll();
    }

    public Roles addRole(Roles roles)
    {
        return roleRepository.save(roles);
    }

    public Roles updateRole( String roleID
            , String name ) throws Exception {

         roleRepository.updateRole(roleID, name);
        return roleRepository.searchRolesByID(roleID);
    }

    public void deleteRole(String id) {
        roleRepository.deleteRolesByID(id);
    }
}


