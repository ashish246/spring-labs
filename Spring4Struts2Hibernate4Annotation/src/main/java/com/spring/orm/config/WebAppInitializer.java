package com.spring.orm.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		// You can see that the Spring framework is configured as a context
		// listener:
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);

		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(
				appContext);
		servletContext.addListener(contextLoaderListener);

		// And the Struts framework is configured as the primary dispatcher
		// filter:
		FilterRegistration.Dynamic filter = servletContext.addFilter(
				"StrutsDispatcher", new StrutsPrepareAndExecuteFilter());
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
				true, "/*");

		// If Its only Spring+Hibernate
		/*
		 * ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
		 * "SpringDispatcher", new DispatcherServlet(appContext));
		 * dispatcher.setLoadOnStartup(1); dispatcher.addMapping("/");
		 */
	}

}