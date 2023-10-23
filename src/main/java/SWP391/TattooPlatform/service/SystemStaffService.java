package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.SystemStaff;
import SWP391.TattooPlatform.repository.SystemStaffRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SystemStaffService {
    final SystemStaffRepository systemStaffRepository;

    public SystemStaffService(SystemStaffRepository systemStaffRepository) {
        this.systemStaffRepository = systemStaffRepository;
    }

    public ResponseEntity<?> getAllSystemStaff() {
        return ResponseUtils.get(systemStaffRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> addNewSystemStaff(SystemStaff systemStaff) {
        return ResponseUtils.get(systemStaffRepository.save(systemStaff),HttpStatus.CREATED);
    }
}
