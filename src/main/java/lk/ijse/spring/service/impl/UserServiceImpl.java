package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save_user(UserDTO dto) {
        if (!userRepo.existsById(dto.getId())){
            userRepo.save(modelMapper.map(dto, User.class));
        }else {
            throw new RuntimeException("User Already Exist..!");
        }
    }

    @Override
    public void delete_user(String id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the User ID.. No Such User..!");
        }
    }

    @Override
    public void update_user(UserDTO dto) {
        if (userRepo.existsById(dto.getId())) {
            userRepo.save(modelMapper.map(dto, User.class));
        } else {
            throw new RuntimeException("No Such User To Update..! Please Check the ID..!");
        }
    }

    @Override
    public UserDTO search_user(String id) {
        if (userRepo.existsById(id)) {
            return modelMapper.map(userRepo.findById(id).get(), UserDTO.class);
        } else {
            throw new RuntimeException("No User For " + id + " ..!");
        }
    }

    @Override
    public List<UserDTO> get_all_user() {
        return modelMapper.map(userRepo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }
}
