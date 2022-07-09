package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.service.RentCarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book_rent")
@CrossOrigin
public class RentCarController {

    @Autowired
    RentCarService rentCarService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil get_all_rents() {
        return new ResponseUtil(200, "Ok", rentCarService.get_all_rents());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil book_rents(@RequestBody RentDTO rentDTO) {
        System.out.println(rentDTO.toString());
        rentCarService.book_rent(rentDTO);
        return new ResponseUtil(200, "Save", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update_rents(@RequestBody RentDTO rentDTO) {
        rentCarService.update_rent(rentDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"oid"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete_rents(@RequestParam String rid) {
        rentCarService.delete_rent(rid);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{rid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search_rents(@PathVariable String rid) {
        return new ResponseUtil(200, "Ok", rentCarService.search_rent(rid));
    }
}
