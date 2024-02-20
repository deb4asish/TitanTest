package com.library.management.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Debasish Padhy
 *
 */

@Configuration
public class BookConfiguration {
	
	@Bean(name = "modelMapper")
	public ModelMapper moderlmapper() {
		return new ModelMapper();
	}

}
