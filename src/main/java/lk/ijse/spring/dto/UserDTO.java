package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
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
