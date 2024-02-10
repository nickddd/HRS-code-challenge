package com.hotel.guesttracking.parcel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "parcel-service")
@RequestMapping("/parcel-service/parcels")
public interface ParcelClient {

    @PostMapping
    public void storeParcelForGuest(@RequestBody ParcelDto parcelDto);

    @GetMapping ("{guestId}")
    public List<ParcelDto> pickUpParcels(@PathVariable long guestId);

}