package com.example.covid_19trackor;

// It is a constructor

class RecyclerViewData {

    private String itemName;
    private int itemImage;

    public RecyclerViewData(String itemName,int itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

}
