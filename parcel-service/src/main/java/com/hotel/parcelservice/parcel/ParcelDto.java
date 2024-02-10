package com.hotel.parcelservice.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParcelDto {

    private long guestId;
    private String parcelCode;
    private String deliveryService;
}
