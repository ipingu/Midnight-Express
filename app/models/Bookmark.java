package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import play.Logger;
import play.cache.Cache;
import play.data.validation.Check;
import play.data.validation.CheckWith;
import play.data.validation.Required;
import play.data.validation.URL;

import siena.Id;
import siena.Model;
import siena.Query;
import siena.Unique;

public class Bookmark extends Model implements Serializable {
	
	@Id
	public Long id;
	
	@Required
	public String url;

	@Required
	public String title;
	
	public Date date;
	
	public Bookmark() {
		this.date = new Date();
	}

	public static int count() {
		return all().count();
	}
	
	public static List<Bookmark> refreshCache() {
		List<Bookmark> bookmarks = Bookmark.all()
			.order("-date")
			.fetch();
	
		Logger.info("Refreshing bookmarks cache with %s items", bookmarks.size());
		Cache.set("bookmarks", bookmarks, "60mn");
		
		return bookmarks;
	}

	public static List<Bookmark> findAll() {
		List<Bookmark> bookmarks = (List<Bookmark>) Cache.get("bookmarks");
		
		if (bookmarks == null)
			bookmarks = refreshCache();
		
		return bookmarks;
	}
	
	private static Query<Bookmark> all() {
		return Bookmark.all(Bookmark.class);
	}

	@Override
	public String toString() {
		return "bookmark {id=" + id + ", title=" + title + "}";
	}
	
	public void insert() {
		super.insert();
		refreshCache();
	}
	
}
