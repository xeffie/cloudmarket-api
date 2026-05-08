package com.cloudmarket.api.listing;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ListingResponse {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String category;
    private ItemCondition itemCondition;
    private String sellerName;
    private ListingStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ListingResponse() {
    }

    public ListingResponse(
            Long id,
            String title,
            String description,
            BigDecimal price,
            String category,
            ItemCondition itemCondition,
            String sellerName,
            ListingStatus status,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.itemCondition = itemCondition;
        this.sellerName = sellerName;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ListingResponse fromListing(Listing listing) {
        return new ListingResponse(
                listing.getId(),
                listing.getTitle(),
                listing.getDescription(),
                listing.getPrice(),
                listing.getCategory(),
                listing.getItemCondition(),
                listing.getSellerName(),
                listing.getStatus(),
                listing.getCreatedAt(),
                listing.getUpdatedAt()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public String getSellerName() {
        return sellerName;
    }

    public ListingStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}