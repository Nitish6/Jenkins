package com.yash.training.springMVC.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringConfigInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
    protected Class<?>[] getRootConfigClasses() {
		return null;
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {        
        return new Class[] { SpringAnnotationConfig.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
