package com.pawel.Schronisko_Spring.config;

import com.pawel.Schronisko_Spring.domain.repository.DBAnimalRepository;
import com.pawel.Schronisko_Spring.domain.repository.InMemoryAnimalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryAnimalRepository")
    @Profile("dev")
    public InMemoryAnimalRepository createInMemoryAnimalRepository()
    {
        InMemoryAnimalRepository inMemoryAnimalRepository = new InMemoryAnimalRepository();
        return inMemoryAnimalRepository;
    }

    @Bean(name = "DBAnimalRepository")
    @Profile("prod")
    @Primary
    public DBAnimalRepository createDBAnimalRepository()
    {
        DBAnimalRepository repository = new DBAnimalRepository();
        return repository;
    }

}
