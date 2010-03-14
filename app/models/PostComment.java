package models;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class PostComment extends Model {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public String nickname;
	
	public String email;
	
	public String content;
	
	public Date creation;
	
	@ManyToOne
	public Post post;
	
	public PostComment() {
		this.creation = new Date();
	}
	
	// actions
	
	public static List<PostComment> findByPost(Post post) {
		return PostComment.all()
			.filter("post", post)
			.order("creation")
			.fetch();
	}
	
	private static Query<PostComment> all() {
		return PostComment.all(PostComment.class);
	}
	
}
