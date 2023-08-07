package pro.sky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import pro.sky.model.Sock;

import java.util.Optional;

/**
 * Репозиторий для работы с БД
 */
@Repository
public interface SocksRepository extends JpaRepository<Sock, Long> {
    Optional<Sock> findSockByColorAndCottonPart(String color, Integer cottonPart);

    @Query(value = "select sum(quantity) from socks where color = :color and cotton_part > :cottonPart ", nativeQuery = true)
    Long countSockByColorAndAndCottonPartMoreThan(String color, Integer cottonPart);
    @Query(value = "select sum(quantity) from socks where color = :color and cotton_part < :cottonPart ", nativeQuery = true)
    Long countSockByColorAndAndCottonPartLessThan(String color, Integer cottonPart);
    @Query(value = "select sum(quantity) from socks where color = :color and cotton_part = :cottonPart ", nativeQuery = true)
    Long countSockByColorAndAndCottonPartEqual(String color, Integer cottonPart);

}
