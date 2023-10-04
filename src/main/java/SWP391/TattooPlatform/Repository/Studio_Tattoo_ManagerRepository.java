package SWP391.TattooPlatform.Repository;

import SWP391.TattooPlatform.Model.Studio_Tattoo_Manager;
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

public interface Studio_Tattoo_ManagerRepository
                extends JpaRepository<Studio_Tattoo_Manager, Long>{
    List<Studio_Tattoo_Manager> findAll();

}
