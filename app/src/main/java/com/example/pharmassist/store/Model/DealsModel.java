package com.example.pharmassist.store.Model;

public class DealsModel {
    public DealsModel(int dealsImage, String dealsTitle, String dealsType, String dealsStorageLife, String dealsDiscountedPrice, String dealsOriginalPrice,String dealsDiscountedPercentage) {
        this.dealsImage = dealsImage;
        this.dealsTitle = dealsTitle;
        this.dealsType = dealsType;
        this.dealsStorageLife = dealsStorageLife;
        this.dealsDiscountedPrice = dealsDiscountedPrice;
        this.dealsOriginalPrice = dealsOriginalPrice;
        this.dealsDiscountedPercentage = dealsDiscountedPercentage;

    }

    private int dealsImage;
    private String dealsTitle;
    private String dealsType;
    private String dealsStorageLife;
    private String dealsDiscountedPrice;



    private String dealsDiscountedPercentage;

    public int getDealsImage() {
        return dealsImage;
    }

    public void setDealsImage(int dealsImage) {
        this.dealsImage = dealsImage;
    }

    public String getDealsTitle() {
        return dealsTitle;
    }

    public void setDealsTitle(String dealsTitle) {
        this.dealsTitle = dealsTitle;
    }

    public String getDealsType() {
        return dealsType;
    }

    public void setDealsType(String dealsType) {
        this.dealsType = dealsType;
    }

    public String getDealsStorageLife() {
        return dealsStorageLife;
    }

    public void setDealsStorageLife(String dealsStorageLife) {
        this.dealsStorageLife = dealsStorageLife;
    }

    public String getDealsDiscountedPrice() {
        return dealsDiscountedPrice;
    }

    public void setDealsDiscountedPrice(String dealsDiscountedPrice) {
        this.dealsDiscountedPrice = dealsDiscountedPrice;
    }

    public String getDealsOriginalPrice() {
        return dealsOriginalPrice;
    }

    public void setDealsOriginalPrice(String dealsOriginalPrice) {
        this.dealsOriginalPrice = dealsOriginalPrice;
    }

    private String dealsOriginalPrice;
    public String getDealsDiscountedPercentage() {
        return dealsDiscountedPercentage;
    }

    public void setDealsDiscountedPercentage(String dealsDiscountedPercentage) {
        this.dealsDiscountedPercentage = dealsDiscountedPercentage;
    }


}
