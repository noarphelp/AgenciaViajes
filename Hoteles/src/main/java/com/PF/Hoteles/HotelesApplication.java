package com.PF.Hoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelesApplication.class, args);
	}

}
