package org.yearup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MainConfig {

    @Bean
    ProductDao productDao(){
        return new SimpleProductDao();
    }
}
