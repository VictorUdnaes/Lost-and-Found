package com.vudnaes.lost_and_found.listing_service;

import com.vudnaes.lost_and_found.listing_service.dto.ListingPreview;
import com.vudnaes.lost_and_found.listing_service.dto.ListingMapper;
import com.vudnaes.lost_and_found.listing_service.model.Listing;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    private final ListingRepository repository;

    public ListingService(ListingRepository repository) {
        this.repository = repository;
    }

    public ListingPreview findListingById(String id) {
        Optional<Listing> listingOptional = repository.findById(id);
        if (listingOptional.isPresent()) {
            return ListingMapper.toPreviewObject(listingOptional.get());
        } else {
            System.out.println("Listing not found");
        }
        return null;
    }

    public ListingPreview findListingByTitle(String title) {
        Optional<Listing> listingOptional = repository.findByTitle(title);
        if (listingOptional.isPresent()) {
            return ListingMapper.toPreviewObject(listingOptional.get());
        } else {
            System.out.println("Listing not found");
        }
        return null;
    }

    // TODO: figure out how to check that all objects are mapped correctly before returning list.
    public List<ListingPreview> getAllListings() {
        return repository.findAll().stream().map(ListingMapper::toPreviewObject).toList();
    }

    public void saveListing(Listing listing) {
        repository.save(listing);
    }

    public void updateListing(String id, Listing listing) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException();
        } else {
            listing.setId(id);
            repository.save(listing);
        }
    }
}
