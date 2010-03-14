package controllers;

import com.google.appengine.repackaged.com.google.common.base.Charsets;

import models.Bookmark;
import play.Logger;
import play.data.validation.CheckWith;
import play.data.validation.Required;
import play.mvc.*;


public class Application extends Controller {

    public static final String CHARSET = "UTF-8";

	public static void index() {
    	render();
    }

}