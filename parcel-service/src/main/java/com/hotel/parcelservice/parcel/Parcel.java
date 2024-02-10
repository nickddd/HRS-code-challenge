package com.hotel.parcelservice.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long guestId;

    private String parcelCode;
    private String deliveryService;
    private boolean pickedUp;

    public Parcel(long guestId, String parcelCode, String deliveryService) {
        this.guestId = guestId;
        this.parcelCode = parcelCode;
        this.deliveryService = deliveryService;
    }

    public void setPickedUp() {
        this.pickedUp = true;
    }
}

