package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Car {
    @Id
    private String cId;
    private String number_of_passengers;
    private String transmission_type;
    private String color;
    private String registration_number;
    private String fuel_type;
    private String brand;
    private String car_type;
    private String status;
    private double price_for_the_extra_km;
    private double free_mileage;
    private double price_for_the_rent_duration;
    private double damage_waver;
    private double run_km;


}
