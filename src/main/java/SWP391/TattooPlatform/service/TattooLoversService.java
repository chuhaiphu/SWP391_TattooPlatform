package SWP391.TattooPlatform.service;
import SWP391.TattooPlatform.model.TattooLovers;
import SWP391.TattooPlatform.repository.TattooLoversRepository;

import java.util.List;

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
    public TattooLovers addTattooLovers(TattooLovers tattooLovers){
        return tattooLoversRepository.save(tattooLovers);
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
