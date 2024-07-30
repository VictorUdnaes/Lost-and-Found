package com.vudnaes.lost_and_found.listing_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Listing {
        @Id
        String id;
        @Indexed(unique = true)
        String title;
        String description;

        public Listing(String title, String description) {
                this.title = title;
                this.description = description;
        }
}
