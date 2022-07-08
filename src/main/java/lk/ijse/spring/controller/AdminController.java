package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil get_all_admin() {
        return new ResponseUtil(200,"Ok",adminService.get_all_admin());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save_admin(@ModelAttribute AdminDTO admin) {
        adminService.save_admin(admin);
        return new ResponseUtil(200,"Save",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update_admin(@RequestBody AdminDTO admin) {
        adminService.update_admin(admin);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete_admin(@RequestParam String id) {
        adminService.delete_admin(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search_admin(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",adminService.search_admin(id));
    }



}
