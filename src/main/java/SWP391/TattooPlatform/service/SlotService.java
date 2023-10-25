package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Slot;
import SWP391.TattooPlatform.repository.SlotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Service
public class SlotService {
    final SlotRepository slotRepository;
    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public ResponseEntity<?> getListSlotByID(String id) {
        if(slotRepository.findSlotsByStudioID(id).isEmpty()) {
            return ResponseUtils.error("Not found any slot in this Studio", HttpStatus.FOUND);
        }
        return ResponseUtils.get(slotRepository.findSlotsByStudioID(id),HttpStatus.FOUND);
    }

    public ResponseEntity<?> getSlotByID(String id) {
            if(slotRepository.findSlotBySlotID(id) == null) {
                return  ResponseUtils.error("Can not found any slot", HttpStatus.FOUND);
            }
            return ResponseUtils.get(slotRepository.findSlotBySlotID(id),HttpStatus.FOUND);
    }

    public ResponseEntity<?> addSlot(Slot slot) {
            return ResponseUtils.get(slotRepository.save(slot),HttpStatus. CREATED);
    }
    public List<Slot> getListSlotByStudioIDAndDate(String id, String date) {
        if(slotRepository.findSlotsByStudioIDAndDate(id,date).isEmpty()) {
            return Collections.emptyList();
        }
        return slotRepository.findSlotsByStudioIDAndDate(id,date);
    }

//    public void addNewSlot(String date, String startTime, String studioID) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//// Parse the start_time string into a LocalDateTime object
//        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
//
//// Add one hour to start_time to calculate the end_time
//        LocalDateTime endDateTime = startDateTime.plusHours(1);
//
//// Format the endDateTime back into a string using the desired format
//        String end_time = endDateTime.format(formatter);


    }





