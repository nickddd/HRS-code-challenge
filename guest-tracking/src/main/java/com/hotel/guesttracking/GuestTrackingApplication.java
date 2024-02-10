package com.hotel.guesttracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.hotel.guesttracking")
public class GuestTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestTrackingApplication.class, args);
	}
}
