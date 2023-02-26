package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**  
 * <p>@开发版本  	：1.0</p>
 *
 * <p>@Copyright   :abyss-xd @ 2021 </p>
 *
 */
@SpringBootApplication
public class AppMain extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppMain.class);
	}

}