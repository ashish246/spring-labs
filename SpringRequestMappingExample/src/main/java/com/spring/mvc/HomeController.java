package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
// We can use it with class definition to create the base URI.
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = "/method0")
	// Above annotation can also be written as @RequestMapping("/method0").
	@ResponseBody
	// using @ResponseBody to send the String response for this web request,
	public String method0() {
		return "method0";
	}

	@RequestMapping(value = { "/method1", "/method1/second" })
	@ResponseBody
	public String method1() {
		return "method1";
	}

	@RequestMapping(value = "/method2", method = RequestMethod.POST)
	@ResponseBody
	public String method2() {
		return "method2";
	}

	@RequestMapping(value = "/method3", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String method3() {
		return "method3";
	}

	@RequestMapping(value = "/method4", headers = "name=Ashish")
	@ResponseBody
	public String method4() {
		return "method4";
	}

	@RequestMapping(value = "/method5", headers = { "name=Ashish", "id=1" })
	@ResponseBody
	public String method5() {
		return "method5";
	}

	@RequestMapping(value = "/method6", produces = { "application/json",
			"application/xml" }, consumes = "text/html")
	@ResponseBody
	public String method6() {
		return "method6";
	}

	@RequestMapping(value = "/method7/{id}")
	@ResponseBody
	public String method7(@PathVariable("id") int id) {
		return "method7 with id=" + id;
	}

	@RequestMapping(value = "/method8/{id:[\\d]+}/{name}")
	@ResponseBody
	public String method8(@PathVariable("id") long id,
			@PathVariable("name") String name) {
		return "method8 with id= " + id + " and name=" + name;
	}

	@RequestMapping(value = "/method9")
	@ResponseBody
	public String method9(@RequestParam("id") int id) {
		return "method9 with id= " + id;
	}

	/**
	 * f value is empty for a method, it works as default method for the
	 * controller class. As you have seen above that we have mapped /home to
	 * HomeController, this method will be used for the default URI requests.
	 * 
	 * @return
	 */
	@RequestMapping()
	@ResponseBody
	public String defaultMethod() {
		return "default method";
	}

	/**
	 * We can create a fallback method for the controller class to make sure we
	 * are catching all the client requests even though there are no matching
	 * handler methods. It is useful in sending custom 404 response pages to
	 * users when there are no handler methods for the request.
	 * 
	 * @return
	 */
	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "fallback method";
	}
}
