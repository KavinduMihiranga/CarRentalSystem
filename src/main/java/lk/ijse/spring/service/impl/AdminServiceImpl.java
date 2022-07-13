package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save_admin(AdminDTO dto) {
        if (!adminRepo.existsById(dto.getAId())){
            adminRepo.save(modelMapper.map(dto, Admin.class));

        }else {
            throw new RuntimeException("Admin Already Exist..!");
        }
    }

    @Override
    public void delete_admin(String id) {
        if (adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Admin ID.. No Such Admin..!");
        }
    }

    @Override
    public void update_admin(AdminDTO dto) {
        if (adminRepo.existsById(dto.getAId())) {
            adminRepo.save(modelMapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("No Such Admin To Update..! Please Check the ID..!");
        }
    }

    @Override
    public AdminDTO search_admin(String id) {
        if (adminRepo.existsById(id)) {
            return modelMapper.map(adminRepo.findById(id).get(), AdminDTO.class);
        } else {
            throw new RuntimeException("No Admin For " + id + " ..!");
        }
    }

    @Override
    public List<AdminDTO> get_all_admin() {
        return modelMapper.map(adminRepo.findAll(), new TypeToken<List<AdminDTO>>() {
        }.getType());
    }
}
