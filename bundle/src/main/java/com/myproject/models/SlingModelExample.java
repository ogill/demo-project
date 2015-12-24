package com.myproject.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables=SlingHttpServletRequest.class)
public class SlingModelExample {

  @Inject @Optional 
  private String param1;
  
  @Inject @Optional 
  private String param2;
  
  @Inject @Optional 
  private String calculatedValue;
  
  @PostConstruct
  public void activate() {
	  System.out.println("Inside SlingModelExample activate " + param1 + " "+ param2);
	  // This is called after all the injection has occurred
	  calculatedValue =  param1 + " " + param2;
  }

  public String getCalculatedValue() {
    return calculatedValue;
  }
}
