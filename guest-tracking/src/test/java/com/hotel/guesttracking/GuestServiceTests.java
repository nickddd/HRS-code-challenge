package com.hotel.guesttracking;


import com.hotel.guesttracking.guest.Guest;
import com.hotel.guesttracking.guest.GuestRepository;
import com.hotel.guesttracking.guest.GuestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GuestServiceTests {

	@SpyBean
	private GuestRepository guestRepository;

	@SpyBean
	private GuestService guestService;

	@Before
	public void init() {
		List<Guest> guestList = new ArrayList<>();
		Guest a = new Guest();
		Guest b = new Guest();
		b.setCheckOut();
		guestList.add(a);
		guestList.add(b);
		when(guestRepository.findAll()).thenReturn(guestList);
	}

	@Test
	public void testGetGuests() {
		List<Guest> res = guestService.getGuests(true);
		Assert.assertEquals(res.size(), 1);
	}

	@Test
	public void testCheckIfCanAcceptParcel() {
		when(guestRepository.findById(1l)).thenReturn(Optional.of(new Guest()));
		Assert.assertEquals(guestService.checkIfCanAcceptParcel(1l), true);
	}
}
