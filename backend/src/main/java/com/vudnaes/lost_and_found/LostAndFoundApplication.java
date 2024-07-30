package com.vudnaes.lost_and_found;

import com.vudnaes.lost_and_found.listing_service.ListingRepository;
import com.vudnaes.lost_and_found.listing_service.model.Listing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LostAndFoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostAndFoundApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner runner(ListingRepository repository) {
        return args -> {
            Listing listing1 = new Listing("Iphone 10", "blue");
            Listing listing2 = new Listing("Yankees caps", "black");

            repository.save(listing1);
            repository.save(listing2);
        };
    }

*/
}
