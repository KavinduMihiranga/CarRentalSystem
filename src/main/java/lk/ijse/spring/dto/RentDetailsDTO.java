package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDetailsDTO {
    private String bId;
    private String cId;
    private String status;
    private int qty;
    private double unitPrice;
    private String needDriver;

}
