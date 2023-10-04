package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.models.Roles;
import SWP391.TattooPlatform.repository.RoleRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Roles> getListRole() {
        if(roleRepository.getAllRole().isEmpty()) {
            return null;
        }
        return roleRepository.getAllRole();
    }

    public String addRole(Roles roles) {
        if(roles == null) {
            return "this role is null";
        }
        if(roles.getRoleID().isEmpty()) {
            return "roleID is null";
        }
        if(roles.getRoleName().isEmpty()) {
            return "role name is null";
        }
        if(roleRepository.getRolesByRoleID(roles.getRoleID())!= null) {
            return "this ID has been used";
        }

         roleRepository.saveRole(roles);
        return "add success";
    }

    public String updateRoleByID(@Param("roleID") String roleID, @Param("newRoleName") String newRoleName){
        try{
            Roles roles = roleRepository.getRolesByRoleID(roleID);
            if(roles == null) {
                return "Can not find this role in data";
            }
            if(newRoleName.isEmpty()) {
                return "Not allow empty";
            }
            roleRepository.updateRoleById(roleID,newRoleName);

        }catch (Exception e) {
            return "something went wrong";

        }
        return "update success";
    }

    public String deleteRoleByID(String roleID) {
            Roles roles = roleRepository.getRolesByRoleID(roleID);
            if(roles != null) {
                roleRepository.deleteByRoleID(roleID);
                return "delete success";
            }
            return "delete fail";
    }
}
