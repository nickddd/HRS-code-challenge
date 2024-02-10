package com.hotel.guesttracking;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GuestTrackingApplicationTests {

	static ConfigurableApplicationContext eurekaServer;

	@BeforeClass
	public static void startEureka() {
		eurekaServer = SpringApplication.run(EurekaServer.class,
				"--server.port=8761",
				"--eureka.instance.leaseRenewalIntervalInSeconds=1");
	}

	@AfterClass
	public static void closeEureka() {
		eurekaServer.close();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void guestTrackingServiceIsUp() throws InterruptedException {

		ResponseEntity<HashMap> response = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/actuator/health", HashMap.class);

		then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		HashMap responseBody = response.getBody();
		then(responseBody).isNotEmpty();
		then(responseBody).containsKey("status");
		then(responseBody).containsValue("UP");
	}


	@Configuration
	@EnableAutoConfiguration
	@EnableEurekaServer
	static class EurekaServer {
	}

}
