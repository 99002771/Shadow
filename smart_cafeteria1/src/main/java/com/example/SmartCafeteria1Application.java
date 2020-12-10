package com.example;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SmartCafeteria1Application {

	public static void main(String[] args) {
		
		TimeZone tz = Calendar.getInstance().getTimeZone();
		System.out.println(tz.getID());
		SpringApplication.run(SmartCafeteria1Application.class, args);
	}

}
