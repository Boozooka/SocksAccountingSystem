package boozooka.ru.SocksAccountingSystem.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {


    @Bean
    Logger logger(){
        Logger logger = LoggerFactory.getLogger("SocksLogger");
        return logger;
    }
}
