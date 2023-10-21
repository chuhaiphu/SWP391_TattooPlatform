package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.Slot;
import SWP391.TattooPlatform.repository.SlotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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




}
