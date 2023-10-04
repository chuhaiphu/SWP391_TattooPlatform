package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Roles,Long> {
        // view
        List<Roles> findAll();

        Roles findRolesByRoleID(String id);
        //search
//        @Query(value = "Select r.roleID, r.roleName from Roles r where r.roleID = :roleID ")
//        Roles searchRolesByID(@Param("roleID") String roleID) ;



        //UPDATE
        @Modifying
        @Transactional
        @Query(value = "UPDATE Roles r SET r.roleName = :name WHERE r.roleID = :roleID ")
        void updateRole(@Param("roleID") String roleID, @Param("name") String name);

        //DELETE
        @Modifying
        @Transactional
        @Query(value = "delete from Roles r where r.roleID = :roleID")
        void deleteRolesByID(@Param("roleID") String roleID);

        //INSERT
        @Transactional
        Roles save(Roles roles);


}
