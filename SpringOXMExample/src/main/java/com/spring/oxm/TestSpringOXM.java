package com.spring.oxm;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.oxm.converter.XMLConverter;
import com.spring.oxm.model.Customer;

/**
 * Wait, why flag and age are converted as attribute? Is that a way to control
 * which field should use as attribute or element? Of course, you can use Castor
 * XML mapping to define the relationship between Object and XML.
 * 
 * @author Administrator
 *
 */
public class TestSpringOXM {

	private static final String XML_FILE_NAME = "customer.xml";

	public static void main(String[] args) throws IOException {

		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring.xml");
		XMLConverter converter = (XMLConverter) appContext
				.getBean("XMLConverter");

		Customer customer = new Customer();
		customer.setName("Ashish");
		customer.setAge(30);
		customer.setFlag(true);
		customer.setAddress("This is address");

		System.out.println("Convert Object to XML!");
		// from object to XML file
		converter.convertFromObjectToXML(customer, XML_FILE_NAME);
		System.out.println("Done \n");

		System.out.println("Convert XML back to Object!");
		// from XML to object
		Customer customer2 = (Customer) converter
				.convertFromXMLToObject(XML_FILE_NAME);
		System.out.println(customer2);
		System.out.println("Done");

		appContext.close();
	}
}
