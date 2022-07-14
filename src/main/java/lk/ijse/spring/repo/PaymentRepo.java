package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PaymentRepo extends JpaRepository<Payment,String> {

    Payment findPaymentByDate(String date);
    Payment findPaymentByBalance(String balance);

}
