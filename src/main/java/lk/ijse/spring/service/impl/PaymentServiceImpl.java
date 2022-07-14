package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save_payment(PaymentDTO dto) {
        if (!paymentRepo.existsById(dto.getPId())){
            paymentRepo.save(modelMapper.map(dto, Payment.class));
        }else {
            throw new RuntimeException("Payment Already Exist..!");
        }
    }

    @Override
    public void delete_payment(String pid) {
        if (paymentRepo.existsById(pid)) {
            paymentRepo.deleteById(pid);
        } else {
            throw new RuntimeException("Please check the Payment ID.. No Such Payment..!");
        }
    }

    @Override
    public void update_payment(PaymentDTO dto) {
        if (paymentRepo.existsById(dto.getPId())) {
            paymentRepo.save(modelMapper.map(dto, Payment.class));
        } else {
            throw new RuntimeException("No Such Payment To Update..! Please Check the ID..!");
        }
    }

    @Override
    public PaymentDTO search_payment(String pid) {
        if (paymentRepo.existsById(pid)) {
            return modelMapper.map(paymentRepo.findById(pid).get(), PaymentDTO.class);
        } else {
            throw new RuntimeException("No Payment For " + pid + " ..!");
        }
    }

    @Override
    public PaymentDTO search_Balance(double balance) {
        if (paymentRepo.existsById(String.valueOf(balance))) {
            return modelMapper.map(paymentRepo.findPaymentByBalance(String.valueOf(balance)).getBalance(), PaymentDTO.class);
        } else {
            throw new RuntimeException("No Payment For " + balance + " ..!");
        }
    }

    @Override
    public PaymentDTO search_payment_with_date(LocalDate date) {
        if (paymentRepo.existsById(String.valueOf(date))) {
            throw new RuntimeException("No Payment For " + date + " ..!");
        } else {
            return modelMapper.map(paymentRepo.findPaymentByDate(String.valueOf(date)).getDate(), PaymentDTO.class);
        }
    }

    @Override
    public List<PaymentDTO> get_all_Payment() {
        return modelMapper.map(paymentRepo.findAll(), new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
