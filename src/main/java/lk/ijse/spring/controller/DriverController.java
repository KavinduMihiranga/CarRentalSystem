package lk.ijse.spring.controller;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {


    @Autowired
    DriverService driverService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil get_all_driver() {
        return new ResponseUtil(200, "Ok", driverService.get_all_driver());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save_driver(@ModelAttribute DriverDTO driver) {
        driverService.save_drive(driver);
        return new ResponseUtil(200, "Save", null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update_driver(@RequestBody DriverDTO driver) {
        driverService.update_driver(driver);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete_driver(@RequestParam String id) {
        driverService.delete_driver(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search_driver(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", driverService.search_driver(id));
    }


}
