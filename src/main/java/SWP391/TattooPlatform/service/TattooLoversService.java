package SWP391.TattooPlatform.service;
import SWP391.TattooPlatform.config.ResponseUtils;
import SWP391.TattooPlatform.model.TattooLovers;
import SWP391.TattooPlatform.repository.TattooLoversRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TattooLoversService {
    final TattooLoversRepository tattooLoversRepository;

    public TattooLoversService(TattooLoversRepository tattooLoversRepository) {
        this.tattooLoversRepository = tattooLoversRepository;
    }
    public List<TattooLovers> getListLovers(){
        if(tattooLoversRepository.findAll().isEmpty()){
            return null;
        }
        return tattooLoversRepository.findAll();
    }

    public ResponseEntity<?> getLoverByEmail(String email) {
        TattooLovers tattooLovers = tattooLoversRepository.findTattooLoversByTattooLoveremail(email);
        if(tattooLovers == null) {
            return ResponseUtils.error("not find any lovers",HttpStatus.BAD_REQUEST);
        }
        return ResponseUtils.get(tattooLovers,HttpStatus.OK);

    }

    public ResponseEntity<?> changePassword(String password, String email) {
           tattooLoversRepository.changePassword(password,email);
           return ResponseUtils.get(tattooLoversRepository.findTattooLoversByTattooLoveremail(email),HttpStatus.OK);
    }


    public ResponseEntity<?> addTattooLovers(TattooLovers tattooLovers){
        if(tattooLoversRepository.findTattooLoversByTattooLoveremail(tattooLovers.getTattooLoveremail()) == null) {
            tattooLovers.setStatusID("1");
            return ResponseUtils.get(tattooLoversRepository.save(tattooLovers),HttpStatus.CREATED);
        }
        return ResponseUtils.error("not allow duplicate email",HttpStatus.BAD_REQUEST);
    }
    public TattooLovers updateTattooLovers  (String tattooLoveremail, String password, String phonenumber, String address )throws Exception{
        tattooLoversRepository.updateTattooLovers(tattooLoveremail, password, phonenumber, address);
        return tattooLoversRepository.findTattooLoversByTattooLoveremail(tattooLoveremail);
    }
    public TattooLovers deteleTattooLovers(String tattooLoveremail ) throws Exception{
        tattooLoversRepository.deleteTattooLoversByTattooLoveremail(tattooLoveremail);
        TattooLovers tattooLovers = tattooLoversRepository.findTattooLoversByTattooLoveremail(tattooLoveremail);
        if(tattooLovers == null){
            return null;
        }
        else
            throw new Exception();
    }



}
