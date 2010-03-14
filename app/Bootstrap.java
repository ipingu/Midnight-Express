import models.Post;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
 
@OnApplicationStart
public class Bootstrap extends Job {
 
	{
		Logger.info("echo !");
	}
	
    public void doJob() {
    	Logger.info("Bootstrap : start doing job");
    	
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
    }
 
}

