package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void save_car(CarDTO dto);

    void delete_car(String cId);

    void update_car(CarDTO dto);

    CarDTO search_car(String cId);

    List<CarDTO> get_all_cars();
//
//    List<CarDTO> findByNumber_of_passengers(String no);
//
//    List<CarDTO> findByTransmission_type(String type);
//
    List<CarDTO> findByBrand(String brand);
//
//    List<CarDTO> findByPrice_for_the_rent_duration(String duration);
//
//    List<CarDTO> findByPrice_for_the_extraKm(String extraKm);
//
//    List<CarDTO> findByFuel_type(String fuel_type);
}
