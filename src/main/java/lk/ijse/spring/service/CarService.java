package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void save_car(CarDTO dto);
    void delete_car(String id);
    void update_car(CarDTO dto);
    CarDTO search_car(String id);
    List<CarDTO> get_all_cars();
}
