package controllers;

import java.util.List;

import models.Post;
import models.PostComment;

import play.Logger;
import play.mvc.Controller;

public class Blog extends Controller {
	
	public static void addComment(Long postId, String nickname, String content) {
		Post post = new Post();
		post.id = postId;
		post.get();
		
		PostComment comment = new PostComment();
		comment.nickname = nickname;
		comment.content = content;
		comment.post = post;
		comment.insert();
		
		flash.success("Thank you %s for your comment !", nickname);
		
		Logger.info("Add comment %s %s %s", postId, nickname, content);
		
		displayByTitle(post.title);
	}

	public static void displayByCategory(String category) {
		if (Post.count() == 0) {
    		Logger.info("Load initial data");
    		
    		Post post = new Post();
    		post.category = "coding";
    		post.content = "My first coding content";
    		post.title = "Chapter 1. Play! framework";
    		post.insert();
    		
    		Post post2 = new Post();
    		post2.category = "misc";
    		post2.content = "misc & stupid content";
    		post2.title = "Chapter 1. Where am I going tonight ?";
    		post2.insert();

    	}
		
		List<Post> posts = Post.findByCategory(category);
		
		renderArgs.put("posts", posts);
		renderArgs.put("category", category);
		render("Blog/displayAsList.html");
	}
	
	public static void displayByTitle(String title) {
		Post post = Post.findByTitle(title);
		display(post);
	}

	public static void displayById(Long id) {
		Post post = Post.findById(id);
		display(post);
	}
	
	private static void display(Post post) {
		if (post == null)
			error(404, "This post does not exists.");
		
		render("Blog/show.html", post);
	}
}
