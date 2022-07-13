package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil get_all_payment() {
        return new ResponseUtil(200, "Ok", paymentService.get_all_Payment());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil pay(@RequestBody PaymentDTO paymentDTO) {
        paymentService.save_payment(paymentDTO);
        return new ResponseUtil(200, "Save", null);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update_payment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.update_payment(paymentDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"pid"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete_payment(@RequestParam String pid) {
        paymentService.delete_payment(pid);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search_payment(@PathVariable String pid) {
        return new ResponseUtil(200, "Ok", paymentService.search_payment(pid));
    }
}
