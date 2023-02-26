package com.cts.EurekaPortfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaPortfolioApplication.class, args);
	}

}
