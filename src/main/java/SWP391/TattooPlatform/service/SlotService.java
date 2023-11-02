package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Slot;
import SWP391.TattooPlatform.repository.SlotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public ResponseEntity<?> getListSlotByStudioIDAndDate(String id, String date) {
        // Get the current real-time LocalDateTime

        if (slotRepository.findSlotsByStudioIDAndDate(id, date).isEmpty()) {
            return ResponseUtils.error("Not found any slot in this Studio", HttpStatus.FOUND);
        }

        List<Slot> slots = slotRepository.findSlotsByStudioIDAndDate(id, date);

        // Compare the current time with the date and time from the database
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Slot> slotList = new ArrayList<>();
        for (Slot slot : slots) {
            LocalDate databaseDate = LocalDate.parse(slot.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalTime databaseTime = LocalTime.parse(slot.getStartTime(), DateTimeFormatter.ofPattern("h:mm a"));
            LocalDateTime databaseDateTime = LocalDateTime.of(databaseDate, databaseTime);

            if (!currentDateTime.isAfter(databaseDateTime)) {
                slotList.add(slot);
            }
        }

        return ResponseUtils.get(slotList, HttpStatus.OK);
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





