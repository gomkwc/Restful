package com.google.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.bean.Body;
import com.google.bean.Fruit;

@Controller
@RequestMapping("/fruit")
public class FruitController {

	@RequestMapping(value="{fruitName}", method = RequestMethod.GET)
	public String getFruit(@PathVariable String fruitName, ModelMap model) {
		Fruit fruit = new Fruit(fruitName, 1);
		Body body = new Body();
		body.setMessage("message");
		fruit.setBody(body);
		model.addAttribute("model", fruit);
		return "listfruit";
	}
	
}
