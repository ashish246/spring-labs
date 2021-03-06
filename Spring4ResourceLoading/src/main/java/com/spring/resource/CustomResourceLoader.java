package com.spring.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CustomResourceLoader implements ResourceLoaderAware {

	private ResourceLoader resourceLoader;

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public void showResourceData() throws IOException {
		// This line will be changed for all versions of other examples
		//Resource banner = resourceLoader.getResource("file:e:/test.txt");
		
		//Resource banner = resourceLoader.getResource("file:root.txt");
		
		Resource banner = resourceLoader.getResource("classpath:classpath.txt");
		
		//Resource banner = resourceLoader.getResource("http://howtodoinjava.com/readme.txt");
		
		InputStream in = banner.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		reader.close();
	}
}