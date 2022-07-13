package lk.ijse.spring.service;

import lk.ijse.spring.dto.RentDTO;

import java.util.List;

public interface RentCarService {
    void book_rent(RentDTO dto);
    void delete_rent(String rId);
    void update_rent(RentDTO dto);
    RentDTO search_rent(String rId);
    List<RentDTO> get_all_rents();
}
