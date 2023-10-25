package SWP391.TattooPlatform.repository;

import SWP391.TattooPlatform.model.Slot;
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
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findAll();

    Slot save(Slot slot);


    List<Slot> findSlotsByStudioID(String studioID);

    Slot findSlotBySlotID(String slotID);

    List<Slot> findSlotsByStudioIDAndDate(String studioID, String date);


    @Modifying
    @Transactional
    @Query("UPDATE  Slot s set " +
            "s.startTime = :startTime" +
            " where  s.slotID = :slotID" )
    void updateSlot(@Param("slotID") String slotID,
                    @Param("startTime") String startTime
                    );


}
