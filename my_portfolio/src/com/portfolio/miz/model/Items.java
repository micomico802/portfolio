package com.portfolio.miz.model;

import javax.servlet.http.HttpServletRequest;

public class Items {
    private String itemId = "";
    private String itemName = "";
    private String arrivalDate = "";
    private String makerName = "";

    public Items() {
    }

    public Items(HttpServletRequest request) {
        this.itemId = request.getParameter("item_id");
        this.itemName = request.getParameter("item_name");
        this.arrivalDate = request.getParameter("arrival_date");
        this.makerName = request.getParameter("maker_name");
    }

    public Items(
            String itemId,
            String itemName,
            String arrivalDate,
            String makerName) {

        this.itemId =itemId;
        this.itemName = itemName;
        this.arrivalDate = arrivalDate;
        this.makerName = makerName;
    }

    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public String getMakerName() {
        return makerName;
    }
    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

}
