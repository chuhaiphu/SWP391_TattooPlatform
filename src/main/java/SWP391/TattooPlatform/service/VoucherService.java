package SWP391.TattooPlatform.service;

import SWP391.TattooPlatform.model.Feedback;
import SWP391.TattooPlatform.model.Voucher;
import SWP391.TattooPlatform.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherService {
    final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }


    public List<Voucher> getVoucherList() {
        if(voucherRepository.findAll().isEmpty()) {
            return null;
        }
        return voucherRepository.findAll();
    }

    public Voucher getVoucherByVoucherID(String voucherID) {
       return voucherRepository.findVoucherByVoucherID(voucherID);
    }

    public Voucher addVoucher(Voucher voucher)
    {
        return voucherRepository.save(voucher);
    }

    public List<Voucher> getVoucherListByStartDate(String date){
        if(voucherRepository.findAllByStartDate(date).isEmpty()) {
            return null;
        }
        return voucherRepository.findAllByStartDate(date);
    }
    public List<Voucher> getVoucherListByEndDate(String date){
        if(voucherRepository.findAllByEndDate(date).isEmpty()) {
            return null;
        }
        return voucherRepository.findAllByEndDate(date);
    }
}
