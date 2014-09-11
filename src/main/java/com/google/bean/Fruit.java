package com.google.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "fruit")
public class Fruit {
	
	private String name;
	
	private int quality;
	
	private Body body;
	 
	public Fruit(String name, int quality) {
		this.name = name;
		this.quality = quality;
	}
 
	public Fruit() {
	}
	
	public Body getBody() {
		return body;
	}
	@XmlElement
	public void setBody(Body body) {
		this.body = body;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getName() {
		return name;
	}
 
	public int getQuality() {
		return quality;
	}


 
}