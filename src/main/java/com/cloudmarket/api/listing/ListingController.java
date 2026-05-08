package com.cloudmarket.api.listing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public ResponseEntity<List<ListingResponse>> getAllListings() {
        List<ListingResponse> listings = listingService.getAllListings();
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingResponse> getListingById(@PathVariable Long id) {
        ListingResponse listing = listingService.getListingById(id);
        return ResponseEntity.ok(listing);
    }

    @PostMapping
    public ResponseEntity<ListingResponse> createListing(@RequestBody ListingRequest request) {
        ListingResponse createdListing = listingService.createListing(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdListing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListingResponse> updateListing(
            @PathVariable Long id,
            @RequestBody ListingRequest request
    ) {
        ListingResponse updatedListing = listingService.updateListing(id, request);
        return ResponseEntity.ok(updatedListing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
        return ResponseEntity.noContent().build();
    }
}