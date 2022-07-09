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
public class Driver {
    @Id
    private String id;
    private String name;
    private String driver_licence_no;
    private String email;
    private String contact_no;
    private String address;
    private boolean status;
}
