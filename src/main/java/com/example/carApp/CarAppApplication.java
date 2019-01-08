package com.example.carApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.carApp.domain.CarRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import com.example.carApp.domain.Car;
//spring JPA name the kosem(sa7er)
@SpringBootApplication
public class CarAppApplication {
	  private static final Logger logger = LoggerFactory.getLogger(CarAppApplication.class);
	   // bbkasha 
	  /*We have to inject our car repository into the main class into be able to save new car objects to the database. 
An @Autowired annotation is used to enable dependency injection. 
The dependency injection allows us to pass dependencies into a object. 
After we have injected the repository class, we can use the CRUD methods it provides.
*/	@Autowired
      private CarRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	    logger.info("Hello Spring Boot");

	}
	@Bean /// the magic creat a resposetory thats include all tha data acces that we write to data base;
    CommandLineRunner runner(){
      return args -> {
//        // Save demo data to database
        repository.save(new Car("Ford", "Mustang", "Red",
         "ADF-1121", 2017, 59000));
        repository.save(new Car("Nissan", "Leaf", "White",
         "SSJ-3002", 2014, 29000));    
         repository.save(new Car("Toyota", "Prius", "Silver",
         "KKO-0212", 2018, 39000));
      };
    } 

}

