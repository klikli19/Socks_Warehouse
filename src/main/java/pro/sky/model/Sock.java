package pro.sky.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "socks")
public class Sock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "cotton_part", nullable = false)
    private Integer cottonPart;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
