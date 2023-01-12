package crew.com.pessoa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ModalMapperConfig {

    @Bean
    public ModelMapper modalMapper() {
        return new ModelMapper();
    }
}
