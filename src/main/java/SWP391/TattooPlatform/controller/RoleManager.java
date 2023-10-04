package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.models.Roles;
import SWP391.TattooPlatform.service.RoleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("role")
public class RoleManager {

    private final RoleService roleService;

    public RoleManager(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("allRole")
    public List<Roles> getAllRoles() {
        return roleService.getListRole();
    }

    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody @Validated Roles roles) {
        return ResponseUtils.get(roleService.addRole(roles), HttpStatus.OK);
    }
}
