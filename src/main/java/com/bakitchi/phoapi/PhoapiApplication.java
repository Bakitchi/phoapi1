package com.bakitchi.phoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}
)
//@ImportResource(locations = {"h-config.xml"})


public class PhoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoapiApplication.class, args);
	}
}
