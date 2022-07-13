package lk.ijse.spring.service;

import lk.ijse.spring.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void save_payment(PaymentDTO dto);
    void delete_payment(String pid);
    void update_payment(PaymentDTO dto);
    PaymentDTO search_payment(String pid);
    List<PaymentDTO> get_all_Payment();
}
