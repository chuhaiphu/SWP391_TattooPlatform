package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.Admin;
import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AdminService {
    public Admin getAdminFromJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = TypeReference.class.getResourceAsStream("/admin.json");
        Admin admin = objectMapper.readValue(inputStream, Admin.class);
        return admin;
    }
}
