package com.devtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
        "com.devtool.service"
})
public class BootDevToolTestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BootDevToolTestApplication.class, args);
	}

}
