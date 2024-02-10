package com.hotel.guesttracking.parcel;

public class ParcelRequest {

    private String lastName;
    private String firstName;
    private String parcelCode;
    private String deliveryService;
    private boolean pickedUp;

    public ParcelRequest() {
        this.pickedUp = false;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getParcelCode() {
        return parcelCode;
    }

    public void setParcelCode(String parcelCode) {
        this.parcelCode = parcelCode;
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp() {
        this.pickedUp = true;
    }
}

