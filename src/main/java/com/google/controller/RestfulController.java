package com.google.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.bean.Body;


@Controller
@RequestMapping("/restful")
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class RestfulController {

	@RequestMapping(value = "/test/{name}/id/{id}", method = RequestMethod.GET)
	public String getString(@PathVariable String name, @PathVariable int id, String email, ModelMap model) {
		System.out.println("name : " + name);
		System.out.println("id : " + id);
		System.out.println("email : " + email);
		model.addAttribute("message", name);
		model.addAttribute("id", id);
		model.addAttribute("email", email);
		return "test";
	}
	
	
	@RequestMapping(value = "/message/{name}", method = RequestMethod.GET)
	public String getMessage(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", name);
		return "list";
	}

	@RequestMapping(value = "/command/{id}/content/{content}", method = RequestMethod.GET)
	public String getCommand(@PathVariable("id") String id,
			@PathVariable("content") long content, ModelMap model) {
		model.addAttribute("id", id);
		model.addAttribute("content", content);
		return "command";
	}

	@RequestMapping(value = "/link/{id}", method = RequestMethod.DELETE)
	public String deleteLink(@PathVariable("id") String id, ModelMap model) {
		model.addAttribute("id", id);
		return "delete";
	}
	
	@RequestMapping(value = "/messagebody/{message}", method = RequestMethod.GET)
	@ResponseBody
	public Body getMessageBody(@PathVariable String message, ModelMap model) {
		Body body = new Body();
		body.setMessage(message);
		return body;
	}
	
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String throwException() {
		throw new ResourceNotFoundException();
	}
	
	@RequestMapping(value = "/exception2", method = RequestMethod.GET)
	public String throwNewException() {
		throw new RuntimeException("test");
	}
	
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY) 
    public void exceptions(ResourceNotFoundException ex, HttpServletRequest request) {
    	System.out.println("handleNotFoundException:" + ex);
    }
    
}

@SuppressWarnings("serial")
class ResourceNotFoundException extends RuntimeException { 
	
} 