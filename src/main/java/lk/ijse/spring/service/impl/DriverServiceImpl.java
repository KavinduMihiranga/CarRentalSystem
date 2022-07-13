package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.DriverDTO;

import lk.ijse.spring.entity.Driver;

import lk.ijse.spring.repo.DriverRepo;

import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save_drive(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDId())){
            driverRepo.save(modelMapper.map(dto, Driver.class));
        }else {
            throw new RuntimeException("Driver Already Exist..!");
        }
    }

    @Override
    public void delete_driver(String id) {
        if (driverRepo.existsById(id)) {
            driverRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Driver ID.. No Such Driver..!");
        }
    }

    @Override
    public void update_driver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDId())) {
            driverRepo.save(modelMapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDTO search_driver(String id) {
        if (driverRepo.existsById(id)) {
            return modelMapper.map(driverRepo.findById(id).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("No Car For " + id + " ..!");
        }
    }

    @Override
    public List<DriverDTO> get_all_driver() {
        return modelMapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }
}
