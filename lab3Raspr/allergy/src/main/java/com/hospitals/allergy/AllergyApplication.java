package com.hospitals.allergy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
public class AllergyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllergyApplication.class, args);
	}

}
