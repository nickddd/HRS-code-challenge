package com.hotel.parcelservice.parcel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    public void addParcel(ParcelDto parcelDto) {
        Parcel parcel = new Parcel(parcelDto.getGuestId(),
                parcelDto.getParcelCode(), parcelDto.getDeliveryService());
        parcelRepository.save(parcel);
    }

    public List<ParcelDto> pickUpParcelsByGuestId(long guestId) {
        List<Parcel> guestParcels = parcelRepository.findByGuestId(guestId);
        guestParcels.forEach(Parcel::setPickedUp);
        List<Parcel> savedParcels = parcelRepository.saveAll(guestParcels);
        return savedParcels.stream().map(p -> new ParcelDto(p.getGuestId(), p.getParcelCode(), p.getDeliveryService()))
                .collect(Collectors.toList());
    }

    public List<Parcel> getParcels() {
        return parcelRepository.findAll();
    }
}
