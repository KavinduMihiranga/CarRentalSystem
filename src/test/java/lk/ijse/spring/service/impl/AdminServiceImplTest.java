package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class AdminServiceImplTest {
    @Autowired
    AdminService adminService;

    public AdminDTO add_one_admin() {
        return new AdminDTO("A00_0001", "Amal", "01234", "amal@gmail.com", "0775698315", "Kaluthara");
    }

    public void add_admins() {
        AdminDTO a1 = new AdminDTO("A00_0001", "Amal", "1234", "amal@gmail.com", "0789898987", "Gall");
        AdminDTO a2 = new AdminDTO("A00_0002", "Namal", "2234", "namal@gmail.com", "0789898984", "Gall");
        AdminDTO a3 = new AdminDTO("A00_0003", "Kamal", "3234", "Kamal@gmail.com", "0789898985", "Gall");
        AdminDTO a4 = new AdminDTO("A00_0004", "Bimal", "4234", "Bimal@gmail.com", "0789898986", "Gall");
        AdminDTO a5 = new AdminDTO("A00_0005", "Nimal", "5234", "Nimal@gmail.com", "0789898988", "Gall");

        adminService.save_admin(a1);
        adminService.save_admin(a2);
        adminService.save_admin(a3);
        adminService.save_admin(a4);
    }

    @Test
    void save_admin() {
        AdminDTO adminDTO1 = add_one_admin();
        assertDoesNotThrow(() -> {
            adminService.save_admin(adminDTO1);
        });

        AdminDTO adminDTO2 = add_one_admin();
        assertDoesNotThrow(() -> {
            adminService.save_admin(adminDTO2);
        });
    }

    @Test
    void delete_admin() {
        add_admins();

        assertDoesNotThrow(() -> {
            adminService.delete_admin("A00_001");
        });

        assertThrows(RuntimeException.class, () -> {
            adminService.delete_admin("A00_007");
        });
    }

    @Test
    void update_admin() {
        add_admins();
        assertDoesNotThrow(() -> {
            adminService.update_admin(new AdminDTO("A00_0001", "Amal", "1234", "amal@gmail.com", "0789898987", "Gall"));
        });

        assertThrows(RuntimeException.class, () -> {
            adminService.update_admin(new AdminDTO("A00_0005", "Bimal", "12354", "bimal@gmail.com", "0789898987", "Gall"));
        });
    }

    @Test
    void search_admin() {
        AdminDTO adminDTO = add_one_admin();
        adminService.save_admin(adminDTO);

        AdminDTO adminDTO1 = adminService.search_admin("A00_001");
        assertNotNull(adminDTO1); // check customer is null or not

        assertThrows(RuntimeException.class, () -> {
            AdminDTO adminDTO2 = adminService.search_admin("A00_002");
        });
    }

    @Test
    void get_all_admin() {
        add_admins();

        List<AdminDTO> all_admins = adminService.get_all_admin();
        for (AdminDTO ass_admin : all_admins) {
            System.out.println(ass_admin.toString());
        }

        //Test customer availability
        assertNotNull(all_admins);
    }
}