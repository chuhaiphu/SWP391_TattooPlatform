package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role,Long> {
        // view
        List<Role> findAll();

        Role findRolesByRoleID(String id);
        //search
//        @Query(value = "Select r.roleID, r.roleName from Roles r where r.roleID = :roleID ")
//        Roles searchRolesByID(@Param("roleID") String roleID) ;



        //UPDATE
        @Modifying
        @Transactional
        @Query(value = "UPDATE Role r SET r.roleName = :name WHERE r.roleID = :roleID ")
        void updateRole(@Param("roleID") String roleID, @Param("name") String name);

        //DELETE
        @Modifying
        @Transactional
        @Query(value = "delete from Role r where r.roleID = :roleID")
        void deleteRolesByID(@Param("roleID") String roleID);

        //INSERT
        @Transactional
        Role save(Role roles);


}
