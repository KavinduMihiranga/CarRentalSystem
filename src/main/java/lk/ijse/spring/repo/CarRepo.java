package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, String> {
//    List<Car> findByNumber_of_passengers(String no);
//
//    List<Car> findByTransmission_type(String type);
//
    List<Car> findByBrand(String brand);
//
//    List<Car> findByPrice_for_the_rent_duration(String duration);
//
//    List<Car> findByPrice_for_the_extra_km(String extraKm);
//
//    List<Car> findByFuel_type(String fuel_type);
}
