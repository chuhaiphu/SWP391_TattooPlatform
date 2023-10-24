package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SystemStaffRepository extends JpaRepository<SystemStaff,Long> {
    List<SystemStaff> findAll();

    SystemStaff save(SystemStaff systemStaff);



}
