package com.iagosilva.api;

import com.iagosilva.api.service.impl.CarServiceImpl;
import com.iagosilva.api.domain.Car;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	/*@Bean
	ApplicationRunner init(CarServiceImpl carService) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				carService.saveCar(car);
			});
			carService.getCars().forEach(System.out::println);
		};
	}*/
}

