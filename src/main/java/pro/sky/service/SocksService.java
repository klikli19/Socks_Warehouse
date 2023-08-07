package pro.sky.service;

import pro.sky.dto.SocksDTO;

public interface SocksService {
    SocksDTO addSocks(SocksDTO socksDTO);
    SocksDTO releaseSocks(SocksDTO socksDTO);
    Long getTotalNumberOfSocks(String color, Integer cottonPart, String operation);
}
