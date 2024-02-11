package com.hotel.parcelservice.parcel;

import com.hotel.parcelservice.guest.GuestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{applicationName}/parcels")
@Slf4j
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @Autowired
    private GuestClient guestClient;

    @PostMapping
    public String addParcel(@RequestBody ParcelDto parcel) {
        if (!guestClient.checkIfCanAcceptParcel(parcel.getGuestId())) {
            return "Parcel receiver is not a guest or the guest has already checked out. Can not accept the parcel.";
        }
        parcelService.addParcel(parcel);
        return "Accept.";
    }

    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelService.getParcels();
    }

    @GetMapping("{guestId}")
    public List<ParcelDto> pickUpParcelsByGuest(@PathVariable int guestId) {
        return parcelService.pickUpParcelsByGuestId(guestId);
    }

}
