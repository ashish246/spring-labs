package com.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * A bean post processor allows additional processing before and after the bean
 * initialization callback method. The main characteristic of a bean post
 * processor is that it will process all the bean instances in the IoC container
 * one by one, not just a single bean instance. Typically, bean post processors
 * are used for checking the validity of bean properties or altering bean
 * properties according to certain criteria.
 * 
 * @author Administrator
 *
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub

		System.out.println("postProcessAfterInitialization() was called.");
		
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub

		System.out.println("postProcessBeforeInitialization() was called.");

		return arg0;
	}

}
