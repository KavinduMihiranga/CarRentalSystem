package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil get_all_car() {
        return new ResponseUtil(200,"Ok",carService.get_all_cars());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save_car(@ModelAttribute CarDTO customer) {
        carService.save_car(customer);
        return new ResponseUtil(200,"Save",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update_car(@RequestBody CarDTO customer) {
        carService.update_car(customer);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete_car(@RequestParam String id) {
        carService.delete_car(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search_car(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",carService.search_car(id));
    }

}
