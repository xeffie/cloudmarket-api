package com.cloudmarket.api.listing;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ListingRepository {

    private final List<Listing> listings = new ArrayList<>();
    private Long nextId = 1L;

    public List<Listing> findAll() {
        return listings;
    }

    public Optional<Listing> findById(Long id) {
        return listings.stream()
                .filter(listing -> listing.getId().equals(id))
                .findFirst();
    }

    public Listing save(Listing listing) {
        if (listing.getId() == null) {
            listing.setId(nextId++);
            listings.add(listing);
        } else {
            deleteById(listing.getId());
            listings.add(listing);
        }

        return listing;
    }

    public void deleteById(Long id) {
        listings.removeIf(listing -> listing.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return listings.stream()
                .anyMatch(listing -> listing.getId().equals(id));
    }
}