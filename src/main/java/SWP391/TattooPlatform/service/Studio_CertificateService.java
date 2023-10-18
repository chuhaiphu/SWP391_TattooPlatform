package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Studio_Certificate;
import SWP391.TattooPlatform.repository.Studio_CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studio_CertificateService {

    Studio_CertificateRepository studioCertificateRepository;

    public Studio_CertificateService(Studio_CertificateRepository studioCertificateRepository) {
        this.studioCertificateRepository = studioCertificateRepository;
    }

    public List<Studio_Certificate> getCertificateList(){
        if(studioCertificateRepository.findAll().isEmpty()) return null;
        else return studioCertificateRepository.findAll();
    }

    public Studio_Certificate addStudioCertificate(Studio_Certificate certificate){
        return studioCertificateRepository.save(certificate);
    }

    public Studio_Certificate updateStudioCertificate(String newName, String newEmail, String certificateId){
        studioCertificateRepository.updateStudio_Certificate(newName, newEmail, certificateId);
        return studioCertificateRepository.findStudio_CertificateByStudioCertificateID(certificateId);
    }

    public Studio_Certificate deleteStudioCertificate(String certificateId) throws Exception {
        studioCertificateRepository.deleteStudio_CertificateByStudioCertificateID(certificateId);
        if(studioCertificateRepository.findStudio_CertificateByStudioCertificateID(certificateId)==null) return null;
        else throw new Exception();
    }
}
