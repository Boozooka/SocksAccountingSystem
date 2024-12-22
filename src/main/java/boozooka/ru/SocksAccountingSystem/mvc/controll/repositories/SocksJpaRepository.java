package boozooka.ru.SocksAccountingSystem.mvc.controll.repositories;

import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocksJpaRepository extends JpaRepository<Socks, Long> {
    Socks findByColorAndCottonPercentage(String color, Integer cottonPercentage);
    List<Socks> findAllByColorAndCottonPercentage(String color, Integer cottonPercentage);
}
