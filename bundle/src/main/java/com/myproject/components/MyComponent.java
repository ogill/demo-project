package com.myproject.components;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class MyComponent  extends WCMUsePojo  {

	  private String value;

	  @Override
	  public void activate() {
	    // helper method to get the default bindings
	    Resource resource = getResource();

	    // access to the parameters via get()
	    String param1 = get("param1", String.class);
	    Page param2 = get("param2", Page.class);

	    value = "Parameter sent: \""+param1 + "\" GetPath(): \"" + resource.getPath() + "\" getTitle(): \""+ param2.getTitle()+"\"";
	  }

	  public String getCalculatedValue() {
		  //System.out.println("Inside getCalculatedValue()");
	    return value;
	  }
}
