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
import java.util.stream.Collectors;

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
    public ResponseEntity<?> getListSlotByStudioIDAndDate(String id, String date) {
        if(slotRepository.findSlotsByStudioIDAndDate(id,date).isEmpty()) {

            return ResponseUtils.get(Collections.emptyList(), HttpStatus.OK);
        }
//        return slotRepository.findSlotsByStudioIDAndDate(id,date);
        return ResponseUtils.get(slotRepository.findSlotsByStudioIDAndDate(id,date), HttpStatus.OK);
    }

    public List<Slot> getListAvailableSlotByStudioIDAndDate(String id, String date) {

        List<Slot> slotList = slotRepository.findSlotsByStudioIDAndDate(id,date);
        if(slotList.isEmpty()) {
            return Collections.emptyList();
        } else {
            // Assuming that the Slot class has a getStatus() method.
            List<Slot> availableSlots = slotList.stream()
                    .filter(slot -> slot.getSlotStatus() == 1) // Adjust this condition as per your status check
                    .collect(Collectors.toList());
            return availableSlots;
        }
    }
//    public ResponseEntity<?> getListSlotByStudioIDAndDate(String id, String date) {
//        // Get the current real-time LocalDateTime
//        LocalDateTime currentTime = LocalDateTime.now();
//
//        if (slotRepository.findSlotsByStudioIDAndDate(id, date).isEmpty()) {
//            return ResponseUtils.error("Not found any slot in this Studio", HttpStatus.FOUND);
//        }
//
//        List<Slot> slots = slotRepository.findSlotsByStudioIDAndDate(id, date);
//
//        // Compare the current time with the date from the database
//        LocalDateTime databaseDate = LocalDateTime.parse(slots.get(0).getDate()); // Replace with your slot date property
//        if (currentTime.isAfter(databaseDate)) {
//            return ResponseUtils.error("The slot has already passed", HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseUtils.get(slots, HttpStatus.OK);
//    }
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





