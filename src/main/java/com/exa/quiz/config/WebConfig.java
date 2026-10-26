package com.exa.quiz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 
 * @author Dillip.Nayak
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.exa.quiz"})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * 
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
}
