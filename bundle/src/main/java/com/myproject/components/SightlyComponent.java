package com.myproject.components;

import com.adobe.cq.sightly.WCMUsePojo;

public class SightlyComponent extends WCMUsePojo  {

	  private String myTitle;
	  private String[] names = new String[]{"john","bob","ted"};

	  @Override
	  public void activate() {
	    myTitle = "My Project " + getCurrentPage().getTitle();
	    	   
	  }

	  public String getMyTitle() {
	    return myTitle;
	  }
	  
	// firstName and lastName are available via Bindings 
	  public String getFullname() {
	    return get("firstName", String.class) + " " + get("lastName", String.class);
	  }

	  public String[] getNames() {
		    return names;
		  }
	  
}
