package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemStaffRepository extends JpaRepository<SystemStaff, String> {
    List<SystemStaff> findAll();

}
