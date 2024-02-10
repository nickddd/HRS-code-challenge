package com.hotel.guesttracking.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Could be moved to a published shared lib and pulled as a gradle dependency
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParcelDto {

    private long guestId;
    private String parcelCode;
    private String deliveryService;
}
