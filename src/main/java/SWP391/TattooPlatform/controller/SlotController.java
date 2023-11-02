package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.Slot;
import SWP391.TattooPlatform.service.SlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {
    final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("allSlot/{studioID}")
    public ResponseEntity<?> getListSlotByID(@PathVariable String studioID) {
        return slotService.getListSlotByID(studioID);
    }

    @GetMapping("/{slotID}")
    public ResponseEntity<?> getSlotByID(@PathVariable String slotID) {
        return slotService.getSlotByID(slotID);
    }
    @GetMapping("/{studioID}/{date}")
    public ResponseEntity<?> getListSlotByStudioIDAndDate(@PathVariable String studioID, @PathVariable String date) {
        return slotService.getListSlotByStudioIDAndDate(studioID, date);
    }
    @PostMapping()
    public ResponseEntity<?> addSlot(@RequestBody Slot slot ) {
        return slotService.addSlot(slot);
    }

}
