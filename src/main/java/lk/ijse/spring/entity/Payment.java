package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Payment {
    @Id
    private String pId;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double rental_fee;
    private double damage_waver;
    private double balance;

}
