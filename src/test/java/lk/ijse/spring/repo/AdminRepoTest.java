package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
class AdminRepoTest {
    @Autowired
    AdminRepo adminRepo;

    @Test
    void save_admin() {
        Admin admin = new Admin("A00_0001", "Amal", "1234", "amal@gmail.com", "0789898987", "Gall");
        adminRepo.save(admin);
    }

    @Test
    void delete_admin() {
        adminRepo.deleteById("A00_001");
    }

    @Test
    void update_admin() {
        if (adminRepo.existsById("A00_002")) {
            Admin admin = new Admin("A00_0001", "Amal", "1234", "amal@gmail.com", "0789898987", "Gall");
            adminRepo.save(admin);
        } else {
            throw new RuntimeException("No Such Admin To Update");
        }
    }

    @Test
    void search_admin() {
        Optional<Admin> optional = adminRepo.findById("A00_001");
        boolean present = optional.isPresent();
        System.out.println(present);

        Admin admin = optional.get();
        System.out.println(admin);
    }

    @Test
    void get_all_admin() {
        List<Admin> all = adminRepo.findAll();
        for (Admin admin : all) {
            System.out.println(admin.toString());
        }
    }
}