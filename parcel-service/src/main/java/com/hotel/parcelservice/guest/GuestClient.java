package com.hotel.parcelservice.guest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
@FeignClient(name = "guest-tracking")
@RequestMapping("/guest-tracking/guests")
public interface GuestClient {

    @GetMapping("{id}/check")
    public boolean checkIfCanAcceptParcel(@PathVariable long id);


}