package com.exa.quiz.initializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.exa.quiz.config.WebConfig;

public class QuizTimeInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	static {
        System.out.println("***** Checking QuizTimeInitializer Loaded *****");
    }
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };
	}

}
