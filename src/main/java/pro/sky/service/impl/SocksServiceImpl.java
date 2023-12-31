package pro.sky.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import pro.sky.constants.Operation;
import pro.sky.dto.SocksDTO;
import pro.sky.exception.SocksNotFoundException;
import pro.sky.mapper.SocksMapper;
import pro.sky.model.Sock;
import pro.sky.repository.SocksRepository;
import pro.sky.service.SocksService;

/**
 * Сервис имплементирующий SocksService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService {
    private final SocksRepository repository;
    private final SocksMapper mapper;


    /**
     * Метод добавления носков на склад
     * @param socksDTO данные о товаре, пришедшие от кладовщика
     * @return сохраненные данныых по носкам в БД (на складе)
     */
    @Override
    public SocksDTO addSocks(SocksDTO socksDTO) {
        log.info("Request to add socks");
        Sock sock = repository.findSockByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart()).
                orElse(new Sock(null, socksDTO.getColor(), socksDTO.getCottonPart(), 0));
        if (sock.getQuantity() == 0) {
            sock.setQuantity(socksDTO.getQuantity());
            repository.save(sock);
        } else {
            sock.setQuantity(socksDTO.getQuantity() + sock.getQuantity());
        }
        repository.save(sock);
        return mapper.toDto(sock);
    }

    /**
     * Метод по отпуску носков со склада
     * @param socksDTO данные по товару, пришедшие от кладовщика
     * @return оставшиеся носки в БД (на складе)
     */
    @Override
    public SocksDTO releaseSocks(SocksDTO socksDTO) {
        log.info("Request to release socks");
        Sock sock = repository.findSockByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart()).orElseThrow(
                () -> new SocksNotFoundException("На складе нет носков  с цветом: " + socksDTO.getColor() +
                        " и с содержанием хлопка равное: " + socksDTO.getCottonPart()));
        int quantity = sock.getQuantity() - socksDTO.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Количество пар не может быть отрицательным числом");
        }
        sock.setQuantity(quantity);
        repository.save(sock);
        return mapper.toDto(sock);
    }

    /**
     * Метод получения общего количества носков на складе, соответствующих переданным данным
     * @param color цвет носков
     * @param cottonPart процент хлопка
     * @param operation оператор сравнения
     * @return количество носков, соответствующих введенным данным
     */
    @Override
    public Long getTotalNumberOfSocks(String color, Integer cottonPart, String operation) {
        log.info("Request to get total number of socks by color: " + color + ", cotton: " + cottonPart + ", operation: " +
                operation);
        Operation operation1 = Operation.fromValue(operation).orElseThrow(IllegalAccessError::new);
        try {
            switch (operation1) {
                case EQUAL:
                    return repository.countSockByColorAndAndCottonPartEqual(color, cottonPart);
                case lESS_THAN:
                    return repository.countSockByColorAndAndCottonPartLessThan(color, cottonPart);
                case MORE_THAN:
                    return repository.countSockByColorAndAndCottonPartMoreThan(color, cottonPart);
                default:
                    throw new RuntimeException("Incorrect input");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
