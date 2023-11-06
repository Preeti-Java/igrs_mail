package com.cg.neel.igrs.mail;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("com.cg.neel.igrs.*")
@ComponentScans(
		value = {
				   @ComponentScan("com.cg.neel.igrs.*"),
				}
		)
@EntityScan(basePackages = { "com.cg.neel.igrs.*" })
@EnableEurekaClient
@EnableFeignClients 
public class IgrsMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgrsMailApplication.class, args);
	}
	

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
