package com.amandaprettypizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class PizzaOrderSystemApplication {
	
	@RequestMapping("/login")
    @ResponseBody
    String home() {
      return "login";
    }

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderSystemApplication.class, args);
	}
}
