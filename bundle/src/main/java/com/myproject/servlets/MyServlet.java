package com.myproject.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(
        label = "Samples - Sling All Methods Servlet",
        description = "Sample implementation of a Sling All Methods Servlet.",
        paths = { "/services/all-sample" },
        methods = { "GET", "POST" }, // Ignored if paths is set - Defaults to GET if not specified
        resourceTypes = { }, // Ignored if paths is set
        selectors = { "print.a4" }, // Ignored if paths is set
        extensions = { "html", "htm" }  // Ignored if paths is set
)
public class MyServlet extends SlingSafeMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(MyServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws ServletException, IOException {
    	/*
    	// Writing HTML in servlets is usually inadvisable, and is better suited to be provided via a JSP/Sightly template
        // This is just an example.
        response.getWriter().write("<html><head></head><body>Hello "
                        + " bob " 
                        + "!</body></html>");
        // By Default the 200 HTTP Response status code is used; below explicitly sets it.                    
        response.setStatus(SlingHttpServletResponse.SC_OK);
        */
        // When constructing a JSON response, leverage the Sling JSON Apis
        JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put("success", true);
            jsonResponse.put("new-world", "my new value");
            // Write the JSON to the response
            response.getWriter().write(jsonResponse.toString(2));
            // Be default, a 200 HTTP Response Status code is used
        } catch (JSONException e) {
            //log.error("Could not formulate JSON response");
            // Servlet failures should always return an approriate HTTP Status code
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // If you do not set your own HTML Response content, the OOTB HATEOS Response is used
            response.getWriter().write("ERROR");
        }
    }
	
    protected final void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws
            ServletException, IOException {
        // Implement custom handling of POST requests

        
        // When constructing a JSON response, leverage the Sling JSON Apis
        JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put("success", true);
            jsonResponse.put("new-world", "my new value");
            // Write the JSON to the response
            response.getWriter().write(jsonResponse.toString(2));
            // Be default, a 200 HTTP Response Status code is used
        } catch (JSONException e) {
            //log.error("Could not formulate JSON response");
            // Servlet failures should always return an approriate HTTP Status code
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // If you do not set your own HTML Response content, the OOTB HATEOS Response is used
            response.getWriter().write("ERROR");
        }
    }
	
}
