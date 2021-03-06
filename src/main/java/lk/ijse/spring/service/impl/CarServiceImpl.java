package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save_car(CarDTO dto) {
        if (!carRepo.existsById(dto.getCId())){
            carRepo.save(modelMapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("Car Already Exist..!");
        }
    }

    @Override
    public void delete_car(String id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Car ID.. No Such Car..!");
        }
    }

    @Override
    public void update_car(CarDTO dto) {
        if (carRepo.existsById(dto.getCId())) {
            carRepo.save(modelMapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("No Such Car To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CarDTO search_car(String id) {
        if (carRepo.existsById(id)) {
            return modelMapper.map(carRepo.findById(id).get(), CarDTO.class);
        } else {
            throw new RuntimeException("No Car For " + id + " ..!");
        }
    }

    @Override
    public List<CarDTO> get_all_cars() {
        return modelMapper.map(carRepo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }
//
//    @Override
//    public List<CarDTO> findByNumber_of_passengers(String no) {
//
//        return modelMapper.map(carRepo.findByNumber_of_passengers(no), new TypeToken<List<CarDTO>>() {
//        }.getType());
//    }
//
//    @Override
//    public List<CarDTO> findByTransmission_type(String type) {
//        return modelMapper.map(carRepo.findByTransmission_type(type), new TypeToken<List<CarDTO>>() {
//        }.getType());
//    }
//
    @Override
    public List<CarDTO> findByBrand(String brand) {
        return modelMapper.map(carRepo.findByBrand(brand), new TypeToken<List<CarDTO>>() {
        }.getType());
    }
//
//    @Override
//    public List<CarDTO> findByPrice_for_the_rent_duration(String duration) {
//        return modelMapper.map(carRepo.findByPrice_for_the_rent_duration(duration), new TypeToken<List<CarDTO>>() {
//        }.getType());
//    }
//
//
//    @Override
//    public List<CarDTO> findByPrice_for_the_extraKm(String extraKm) {
//
//        return modelMapper.map(carRepo.findByPrice_for_the_extra_km(extraKm), new TypeToken<List<CarDTO>>() {
//        }.getType());
//    }
//
//
//    @Override
//    public List<CarDTO> findByFuel_type(String fuel_type) {
//        return modelMapper.map(carRepo.findByFuel_type(fuel_type), new TypeToken<List<CarDTO>>() {
//        }.getType());
//    }
}
