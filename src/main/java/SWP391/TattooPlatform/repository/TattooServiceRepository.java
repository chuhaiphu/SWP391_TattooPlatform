package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Service;
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
public interface TattooServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findAll();

    Service findServiceByServiceID(String service_ID);
    List<Service> findServicesByServiceName(String serviceName);


    Service save(Service service);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Service s SET s.serviceName = :serviceName, s.description = :description" +
            ", s.linkImage = :linkImage, s.price = :price WHERE s.serviceID = :serviceID  ")
    void updateService(@Param("serviceID") String serviceID, @Param("serviceName") String serviceName, @Param("description") String description
                         , @Param("linkImage") String linkImage,@Param("price") float price );

    //DELETE
    @Modifying
    @Transactional
    @Query(value = "delete from Service s where s.serviceID = :serviceID")
    void deleteService(@Param("serviceID") String serviceID);



}
