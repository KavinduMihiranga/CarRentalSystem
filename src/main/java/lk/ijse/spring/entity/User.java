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
public class User {
    @Id
    private String id;
    private String name;
    private String other_required_detail;
    private String pick_up_time_and_date;
    private String email;
    private String address;
    private String contact_no;
    private String identity_card_img;
    private String driving_licence_img;

}
