package com.creative.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.creative.model.UpdateDetails;
import com.creative.model.UserPost;

@RestController
@RequestMapping("/service")
public class UserPostController {
	@Autowired
	private UserPostService userPostService;
		@RequestMapping(value="/postAd", method=RequestMethod.POST)
	    public @ResponseBody String saveUserPost(@RequestParam("Category") String Category,@RequestParam("Sub_Category") String Sub_Category,@RequestParam("userName") String userName,@RequestBody UserPost userPost) {
		 System.out.println("Category----------->"+Category);
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    	Calendar cal = Calendar.getInstance();
	    	UpdateDetails updateDetails=new UpdateDetails();
	       	updateDetails.setCreatedBy(userName);
	    	updateDetails.setCreatedTS(dateFormat.format(cal.getTime()));
	    	updateDetails.setUpdatedBy(userName);
	    	updateDetails.setUpdatedBy(dateFormat.format(cal.getTime()));
	    	userPost.setUpdateDetails(updateDetails);
		 userPost.setCategory(Category);
		 userPost.setSub_Category(Sub_Category);
	    userPostService.saveUserPost(userPost);
		return null;
	    }
		
		@RequestMapping(value="/postedAd", method=RequestMethod.GET)
	    public @ResponseBody List<UserPost> userDetail() {
	    	//System.out.println("----------->" +userService.getUsers(emailId, password));
	       return userPostService.getUserPosts();
	    }
	
}
