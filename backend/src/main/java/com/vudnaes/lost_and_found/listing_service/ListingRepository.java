package com.vudnaes.lost_and_found.listing_service;


import com.vudnaes.lost_and_found.listing_service.model.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ListingRepository extends MongoRepository<Listing, String>{
    public Optional<Listing> findByTitle(String title);
}
