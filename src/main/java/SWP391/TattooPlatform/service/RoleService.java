package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Role;
import SWP391.TattooPlatform.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {
    final  RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }



    public List<Role> getListRole() {
        if(roleRepository.findAll().isEmpty()) {
            return null;
        }
        return roleRepository.findAll();
    }

    public Role addRole(Role role)
    {
        return roleRepository.save(role);
    }

    public Role updateRole(String roleID
            , String name ) throws Exception {

        roleRepository.updateRole(roleID, name);
        return roleRepository.findRolesByRoleID(roleID);
    }

    public Role deleteRole(String id) throws Exception{
        roleRepository.deleteRolesByID(id);
        Role role = roleRepository.findRolesByRoleID(id);
        if(role == null) {
            return null;
        }else {
            throw new Exception();
        }
    }
}


