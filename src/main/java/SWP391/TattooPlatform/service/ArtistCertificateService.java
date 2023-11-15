package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Artist_Certificate;
import SWP391.TattooPlatform.repository.ArtistCertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArtistCertificateService {
    final ArtistCertificateRepository artistCertificateRepository;

    public ArtistCertificateService(ArtistCertificateRepository artistCertificateRepository) {
        this.artistCertificateRepository = artistCertificateRepository;
    }


    public List<Artist_Certificate> getListArtistCertificate() {
        if(artistCertificateRepository.findAll().isEmpty()) {
            return null;
        }
        return artistCertificateRepository.findAll();
    }

    public Artist_Certificate addArtistCertificate(Artist_Certificate artistCertificate){
        return artistCertificateRepository.save(artistCertificate);
    }

    public Artist_Certificate updateArtistCertificate(String certificateID
            , String certificateName ) throws Exception {

        artistCertificateRepository.updateCertificate(certificateID, certificateName);
        return artistCertificateRepository.findCertificatesByCertificateID(certificateID);
    }

    public Artist_Certificate deleteArtistCertificates(String certificateID) throws Exception{
        artistCertificateRepository.deleteCertificatesByID(certificateID);
        Artist_Certificate artistCertificate = artistCertificateRepository.findCertificatesByCertificateID(certificateID);
        if(artistCertificate == null) {
            return null;
        }else {
            throw new Exception();
        }
    }
    public boolean checkCertificate(String certificateName, String artistEmail) {
        return artistCertificateRepository.existsByCertificateNameAndArtistEmail(certificateName, artistEmail);
    }
}
