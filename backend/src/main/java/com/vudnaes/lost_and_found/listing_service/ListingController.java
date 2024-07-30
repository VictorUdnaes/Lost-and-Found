package com.vudnaes.lost_and_found.listing_service;

import com.vudnaes.lost_and_found.listing_service.dto.ListingPreview;
import com.vudnaes.lost_and_found.listing_service.model.Listing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/listings")
@CrossOrigin(origins = "http://localhost:5173")
public class ListingController {

    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public List<ListingPreview> getAllListings() {
        return listingService.getAllListings();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ListingPreview> findById(@PathVariable String id) {
        ListingPreview response = listingService.findListingById(id);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ListingPreview> findByTitle(@RequestParam String title) {
       return ResponseEntity.status(200).body(listingService.findListingByTitle(title));
    }

    @PostMapping("/create-listing")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveListing(@RequestBody Listing listing) {
        listingService.saveListing(listing);
    }

    @PutMapping("/update-listing/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateListing(@PathVariable String id, @RequestBody Listing listing) {
        listingService.updateListing(id, listing);
    }
}
