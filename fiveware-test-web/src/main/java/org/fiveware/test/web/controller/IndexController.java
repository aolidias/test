package org.fiveware.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Default controller to redirect to contact register page
 * @author aolidias
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "Contact";
	    }

}