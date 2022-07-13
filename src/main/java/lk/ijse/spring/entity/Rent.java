package lk.ijse.spring.entity;

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
public class Rent {
    @Id
    private String rId;
    private LocalDate date;

    //Out=verse
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "userId",referencedColumnName = "uId",nullable = false)
    private User user;

    //Inverse
    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails;
}
