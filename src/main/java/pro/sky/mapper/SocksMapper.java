package pro.sky.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pro.sky.dto.SocksDTO;
import pro.sky.model.Sock;

/**
 * Класс для преобразования сущности в ДТО и наоборот
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SocksMapper {
    SocksDTO toDto(Sock sock);

    Sock toEntity(SocksDTO socksDTO);
}
