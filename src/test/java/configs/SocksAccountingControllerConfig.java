package configs;

import boozooka.ru.SocksAccountingSystem.mvc.controll.controllers.SockAccountingController;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.controllers.SockAccountingControllerInterface;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services.SockAccountingServiceInterface;
import boozooka.ru.SocksAccountingSystem.mvc.controll.repositories.SocksJpaRepository;
import boozooka.ru.SocksAccountingSystem.mvc.controll.services.SockAccountingService;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocksAccountingControllerConfig {

    @Bean
    SockAccountingControllerInterface controller(){
        return new SockAccountingController();
    }

    @Bean
    SockAccountingServiceInterface service(){
        SockAccountingService result = Mockito.mock(SockAccountingService.class);

        return result;
    }

    @Bean
    Logger logger(){
        return Mockito.mock(Logger.class);
    }

    @Bean
    SocksJpaRepository repository(){
        return Mockito.mock(SocksJpaRepository.class);
    }
}
