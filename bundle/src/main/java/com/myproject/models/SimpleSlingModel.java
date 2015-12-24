package com.myproject.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = SlingHttpServletRequest.class)
public class SimpleSlingModel {
	@Inject @Optional
	private String email;
	@Inject @Optional
	private String firstName;

	@PostConstruct
	protected void init() {
		System.out.println("Inside SimpleSlingModel init()");
		//email += email + " worked!"; 
	}
	
	  @PostConstruct
	  public void activate() {
		  System.out.println("Inside SimpleSlingModel activate");
		  // This is called after all the injection has occurred
		  //email =  email + " actiavte ";
	  }
	
	public String getEmail(){
		return "Email passed in was "+email;
	}
	
	public String getFirstName(){
		return "FirstName passed in was "+firstName;
	}
}
