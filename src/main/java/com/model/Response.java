package com.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class Response {
	
	private boolean status;
	private String message;
	
}
