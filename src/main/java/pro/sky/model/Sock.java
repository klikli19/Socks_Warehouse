package pro.sky.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс Носки
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "socks")
public class Sock {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * Цвет носков
     */
    @Column(name = "color", nullable = false)
    private String color;

    /**
     * Процент хлопка
     */
    @Column(name = "cotton_part", nullable = false)
    private Integer cottonPart;

    /**
     * Количество пар
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
