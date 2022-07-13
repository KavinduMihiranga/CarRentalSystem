package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDTO;

import java.util.List;

public interface UserService {
    void save_user(UserDTO dto);
    void delete_user(String uId);
    void update_user(UserDTO dto);
    UserDTO search_user(String uId);
    List<UserDTO> get_all_user();
}
