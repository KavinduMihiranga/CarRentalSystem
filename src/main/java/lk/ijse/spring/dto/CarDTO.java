package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
    @Id
    private String id;
    private String number_of_passengers;
    private String transmission_type;
    private String color;
    private String registration_number;
    private String fuel_type;
    private String brand;
    private double price_for_the_extra_km;
    private double free_mileage;
    private double price_for_the_rent_duration;
}
