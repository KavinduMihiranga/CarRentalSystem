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
//  @GetMapping(path = "/{passenger}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil search_no_of_passenger(@PathVariable String passenger) {
//        return new ResponseUtil(200,"Ok",carService.findByNumber_of_passengers(passenger));
//    }
// @GetMapping(path = "/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil search_transmission_type(@PathVariable String type) {
//        return new ResponseUtil(200,"Ok",carService.findByTransmission_type(type));
//    }
 @GetMapping(path = "/brand{brand}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search_brand(@PathVariable String brand) {
        return new ResponseUtil(200,"Ok",carService.findByBrand(brand));
    }
// @GetMapping(path = "/{rent}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil search_rent(@PathVariable String rent) {
//        return new ResponseUtil(200,"Ok",carService.findByPrice_for_the_rent_duration(rent));
//    }
// @GetMapping(path = "/{extra}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil search_extraKm(@PathVariable String extra) {
//        return new ResponseUtil(200,"Ok",carService.findByPrice_for_the_extraKm(extra));
//    }
// @GetMapping(path = "/fuel_type{fuel_type}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil search_fuel_type(@PathVariable String fuel_type) {
//        return new ResponseUtil(200,"Ok",carService.findByFuel_type(fuel_type));
//    }

}
