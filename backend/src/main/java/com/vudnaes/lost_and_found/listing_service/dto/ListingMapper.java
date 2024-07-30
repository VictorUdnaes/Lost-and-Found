package com.vudnaes.lost_and_found.listing_service.dto;

import com.vudnaes.lost_and_found.listing_service.model.Listing;

public class ListingMapper {

    public static ListingPreview toPreviewObject(Listing listing) {
        return new ListingPreview(listing.getTitle(), listing.getDescription());
    }
}
