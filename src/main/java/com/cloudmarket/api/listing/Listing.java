package com.cloudmarket.api.listing;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Listing {

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

    public Listing() {
    }

    public Listing(
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(ItemCondition itemCondition) {
        this.itemCondition = itemCondition;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public ListingStatus getStatus() {
        return status;
    }

    public void setStatus(ListingStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}