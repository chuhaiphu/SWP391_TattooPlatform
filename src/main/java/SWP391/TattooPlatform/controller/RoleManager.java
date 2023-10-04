package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.models.ResponseDTO;
import SWP391.TattooPlatform.models.Roles;
import SWP391.TattooPlatform.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/role")
public class RoleManager {




    final RoleService roleService;

    @Autowired
    public RoleManager(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/allRole")
    public Object getAllRoles () {
        return  ResponseUtils.get(roleService.getListRole(),HttpStatus.OK);
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> saveRole(@RequestBody Roles roles) {
        return ResponseUtils.get(roleService.addRole(roles), HttpStatus.CREATED);
    }

    @PutMapping("/updateRole/{roleID}")
    public ResponseEntity<?> updateRole(@RequestParam String name, @PathVariable String roleID) throws Exception {
        return ResponseUtils.get(roleService.updateRole(roleID,name),HttpStatus.OK);
    }

    @DeleteMapping("/deleteRole/{roleID}")
    public ResponseEntity<?> deleteRole(@PathVariable("roleID") String roleID) throws Exception {
        return ResponseUtils.get(roleService.deleteRole(roleID), HttpStatus.OK);

    }
}
