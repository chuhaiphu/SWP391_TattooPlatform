package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleRepository")
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Roles,Long> {
        // view
        List<Roles> findAll();







}
