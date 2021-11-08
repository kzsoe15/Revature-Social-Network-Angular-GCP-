package socialMediaWebApp.servicelayer;

import java.util.List;

import socialMediaWebApp.models.Account;
import socialMediaWebApp.models.LikedPost;


public interface LikedPostService 
{
	//gets all posts that are inside the liked post
	public List<LikedPost> getAllLikedPosts();
	
	public List<LikedPost> getMyLikedPosts(Account myAccount);
	
	public boolean haveILiked(int userId, int postId);
		
	//deletes a liked post from the table
	public void unlikePost(LikedPost likePost);
	
	//adds a liked post to the table
	public void likePost(LikedPost likePost);
}
