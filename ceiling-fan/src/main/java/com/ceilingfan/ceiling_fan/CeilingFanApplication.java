package com.ceilingfan.ceiling_fan;

import com.ceilingfan.ceiling_fan.pojo.CeilingFan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CeilingFanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeilingFanApplication.class, args);
	}

	@Bean
	public CeilingFan startCeilingFan(){
		return new CeilingFan();
	}
}
