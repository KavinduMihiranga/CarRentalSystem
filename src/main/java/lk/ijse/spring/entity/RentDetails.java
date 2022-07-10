package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@IdClass(RentCar_PK.class)
public class RentDetails {
    @Id
    private String rid;
    @Id
    private String carId;
    private String status;
    private int qty;
    private double unitPrice;

    //Out-Verse
    @ManyToOne
    @JoinColumn(name = "rid",referencedColumnName = "rid",insertable = false,updatable = false)
    private Rent rent;

    //Out-verse
    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "id",insertable = false,updatable = false)
    private Car car;
}
