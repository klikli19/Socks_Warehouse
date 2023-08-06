package pro.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class SocksDTO {
    private String color;
    @Positive
    @Max(value = 100, message = "Процент хлопка в составе должен быть не больше 100%")
    private Integer cottonPart;
    @Min(value = 1, message = "Количество пар носков должно быть не меньше 1")
    private Integer quantity;

}
