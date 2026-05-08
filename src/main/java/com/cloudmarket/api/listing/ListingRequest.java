package com.cloudmarket.api.listing;

import java.math.BigDecimal;

public class ListingRequest {

    private String title;
    private String description;
    private BigDecimal price;
    private String category;
    private ItemCondition itemCondition;
    private String sellerName;
    private ListingStatus status;

    public ListingRequest() {
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
}