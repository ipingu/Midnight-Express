package controllers;

import models.Bookmark;
import play.Logger;
import play.data.validation.Required;
import play.mvc.Controller;

public class Sandbox extends Controller {

    public static void index() {
    	render();
    }
    
    public static void addBookmark(@Required String url, @Required String title) {
// 		Annotation on method parameters are used instead
//
//    	validation.required(url);
//    	validation.required(title);
    	
    	if (validation.hasErrors()) {
    		// Without validation.keep(), errors won't be available 
    		// in Application.index() action
    		validation.keep(); 
    		
    		// keep http params for next action, allowing form to display
    		// submitted values
    		params.flash();
    	} else {
    		Bookmark bookmark = new Bookmark();
    		bookmark.title = title;
    		bookmark.url = url;
    		
    		bookmark.insert();
    		
    		flash.success("Bookmark was successfully added");
    		Logger.info("New insertion %s", bookmark);
    	}
    	
    	index();
    }
	
}
