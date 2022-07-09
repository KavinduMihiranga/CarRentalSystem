package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void save_drive(DriverDTO dto);
    void delete_driver(String id);
    void update_driver(DriverDTO dto);
    DriverDTO search_driver(String id);
    List<DriverDTO> get_all_driver();
}
