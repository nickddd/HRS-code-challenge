package com.hotel.guesttracking.guest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public void addGuest(Guest guest) {
        log.info("Add guest " + guest.getFirstName() + " " + guest.getLastName());
        guestRepository.save(guest);
    }

    public Guest getGuestById(long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public List<Guest> getGuests(boolean checkedIn) {
        List<Guest> guestList = guestRepository.findAll();
        if (checkedIn)
            return guestList.stream().filter(g -> g.getCheckOut() == null).collect(Collectors.toList());
        return guestList;
    }

    public void checkoutGuest(long id) {
        Guest guest = guestRepository.getOne(id);
        guest.setCheckOut();
        log.info("guest " + guest.getId() + " has checked out");
        guestRepository.save(guest);
    }

    public boolean checkIfCanAcceptParcel(long id) {
        Guest guest = guestRepository.findById(id).orElse(null);
        if (guest == null) {
            return false;
        }
        return guest.getCheckOut() == null;
    }


    public Guest getGuestByName(String lastName, String firstName) {
        return guestRepository.findByLastNameAndFirstName(lastName, firstName);
    }
}
