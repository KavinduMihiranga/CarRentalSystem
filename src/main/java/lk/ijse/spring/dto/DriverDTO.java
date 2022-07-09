package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String id;
    private String name;
    private String password;
    private String driver_licence_no;
    private String email;
    private String contact_no;
    private String address;
}
