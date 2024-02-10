package com.hotel.guesttracking.guest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Guest() {
        checkIn = LocalDateTime.now();
    }

    public void setCheckOut() {
        this.checkOut = LocalDateTime.now();
    }
}
