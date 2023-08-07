package pro.sky.service;

import pro.sky.dto.SocksDTO;

/**
 * Интерфейс для работы с носками: добавление, отпуск, общее количество, солтветствующее определенному составу
 */
public interface SocksService {
    SocksDTO addSocks(SocksDTO socksDTO);
    SocksDTO releaseSocks(SocksDTO socksDTO);
    Long getTotalNumberOfSocks(String color, Integer cottonPart, String operation);
}
