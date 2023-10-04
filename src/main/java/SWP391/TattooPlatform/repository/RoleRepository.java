package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.models.Roles;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleRepository")
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Roles,Long> {
        // view
        List<Roles> getAllRole();

        @Transactional
        void saveRole(Roles role);

        //UPDATE
        @Modifying
        @Transactional
        @Query("UPDATE Roles r SET r.roleID = :roleID WHERE r.roleName = :newRoleName")
        void updateRoleById(@Param("roleID") String roleID, @Param("newRoleName") String newRoleName);

        @Transactional
        void deleteByRoleID(String roleID);

        Roles getRolesByRoleID(String roleID);



}
