package com.cloudmarket.api.listing;

import org.springframework.stereotype.Service;
import com.cloudmarket.api.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<ListingResponse> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(ListingResponse::fromListing)
                .toList();
    }

    public ListingResponse getListingById(Long id) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing with id " + id + " was not found"));

        return ListingResponse.fromListing(listing);
    }

    public ListingResponse createListing(ListingRequest request) {
        LocalDateTime now = LocalDateTime.now();

        Listing listing = new Listing();
        listing.setTitle(request.getTitle());
        listing.setDescription(request.getDescription());
        listing.setPrice(request.getPrice());
        listing.setCategory(request.getCategory());
        listing.setItemCondition(request.getItemCondition());
        listing.setSellerName(request.getSellerName());
        listing.setStatus(request.getStatus() != null ? request.getStatus() : ListingStatus.AVAILABLE);
        listing.setCreatedAt(now);
        listing.setUpdatedAt(now);

        Listing savedListing = listingRepository.save(listing);

        return ListingResponse.fromListing(savedListing);
    }

    public ListingResponse updateListing(Long id, ListingRequest request) {
        Listing existingListing = listingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing with id " + id + " was not found"));

        existingListing.setTitle(request.getTitle());
        existingListing.setDescription(request.getDescription());
        existingListing.setPrice(request.getPrice());
        existingListing.setCategory(request.getCategory());
        existingListing.setItemCondition(request.getItemCondition());
        existingListing.setSellerName(request.getSellerName());
        existingListing.setStatus(request.getStatus() != null ? request.getStatus() : existingListing.getStatus());
        existingListing.setUpdatedAt(LocalDateTime.now());

        Listing updatedListing = listingRepository.save(existingListing);

        return ListingResponse.fromListing(updatedListing);
    }

    public void deleteListing(Long id) {
        if (!listingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Listing with id " + id + " was not found");
        }

        listingRepository.deleteById(id);
    }
}