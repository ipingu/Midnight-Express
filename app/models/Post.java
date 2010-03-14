package models;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.google.appengine.repackaged.com.google.common.base.Charsets;

import controllers.Application;

import net.sf.ehcache.bootstrap.BootstrapCacheLoader;

import play.data.validation.Required;
import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Post extends Model {

	// Model
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;

	@Required
	public String title;
	
	public String content;
	
	public Date creation;
	
	public String category;
	
	public Post() {
		super();
		this.creation = new Date();
	}


	private static Query<Post> all() {
		return Post.all(Post.class);
	}
	
	
	// Actions
	
	public static List<Post> findByCategory(String category) {
		return all()
			.filter("category", category)
			.order("-creation")
			.fetch();
	}
	
	public static List<Post> findLatest(Integer count) {
		return all()
			.order("-creation")
			.fetch(count);
	}


	public static Post findByTitle(String title) {
		Post post = null;
		try {
			title = URLDecoder.decode(title, Application.CHARSET);
			
			post = all()
				.filter("title", title)
				.get();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return post;
	}

	public static int count() {
		return all().count();
	}


	public static Post findById(Long id) {
		return all()
			.filter("id", id)
			.get();
	}
	
	public List<PostComment> getComments() {
		return PostComment.findByPost(this);
	}
	
}
