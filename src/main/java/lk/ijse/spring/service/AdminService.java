package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;

import java.util.List;

public interface AdminService {
    void save_admin(AdminDTO dto);
    void delete_admin(String id);
    void update_admin(AdminDTO dto);
    AdminDTO search_admin(String id);
    List<AdminDTO> get_all_admin();
}
