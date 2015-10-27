package com.creative.service;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.creative.model.Interest;
import com.creative.model.UpdateDetails;
import com.creative.model.User;
import com.creative.model.UserDetails;
import com.creative.model.UserImage;
import com.creative.model.UserInterest;

@RestController
@RequestMapping("/service")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private InterestService interestService;
    @RequestMapping(value="/saveUser", method=RequestMethod.POST)
    public @ResponseBody String saveUser(@RequestParam("interestID") List interestID,@RequestBody User user) {
    	System.out.println(user);
    	System.out.println(interestID);   	
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Calendar cal = Calendar.getInstance();
    	UpdateDetails updateDetails=new UpdateDetails();
    	
    	updateDetails.setCreatedBy(user.getfName()+" "+user.getlName());
    	updateDetails.setCreatedTS(dateFormat.format(cal.getTime()));
    	List<UserInterest> userInterestList=new ArrayList<UserInterest>();
    	for(Object interest:interestID)
    	{
    		UserInterest userInterest= new UserInterest();
    		userInterest.setUser(user);
    		userInterest.setInterestId(Integer.parseInt(interest.toString()));
    		userInterest.setUpdateDetails(updateDetails);
    		userInterestList.add(userInterest);
    		
    	}
    	
    	 UserDetails userDetails=user.getUserDetails();
    	userDetails.setUser(user);
    	userDetails.setUpdateDetails(updateDetails);
    	user.setUserDetails(userDetails);
      	user.setUpdateDetails(updateDetails);
       	user.setUserInterest(userInterestList);
    	userService.saveUser(user);
		return null;
    }
     
    @RequestMapping(value="/loginUser", method=RequestMethod.GET)
    public @ResponseBody int loginUser(@RequestParam("emailId") String emailId,@RequestParam("password") String password) {
    	System.out.println("----------->" +userService.getUsers(emailId, password));
       return userService.getUsers(emailId, password);
    }
    
    @RequestMapping(value="/getPassword", method=RequestMethod.GET, produces = "text/plain; charset=utf-8")
    public @ResponseBody String userPassword(@RequestParam("emailId") String emailId) {
    	System.out.println("----------->" +userService.getUserPwd(emailId));
       return userService.getUserPwd(emailId);
    }
    
    @RequestMapping(value="/userName", method=RequestMethod.GET, produces = "text/plain; charset=utf-8")
    public @ResponseBody String userDetail(@RequestParam("userID") int userID) {
    	//System.out.println("----------->" +userService.getUsers(emailId, password));
       return userService.getUserDetails(userID);
    }
    
    
    
	@RequestMapping(value="/uploadImage", method=RequestMethod.POST)
    public void upload(UserImage userImage,@RequestParam("file") MultipartFile file, @RequestParam("userID") Integer userID) throws IOException {
    	byte[] bytes;
    	System.out.println(userID);
    	
    	//userImage.setImageID(1);
    	userImage.setUserID(userID);
		if (!file.isEmpty()) {
			bytes = file.getBytes();

			userImage.setProfileImage(bytes);
		}
       
        userService.saveImage(userImage);    

        System.out.println(String.format("receive %s from %s", file.getOriginalFilename(),userID));
    }
	
	
	@RequestMapping(value="/getProfileImage", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserImage> getProfileImage(@RequestParam("userID") Integer userID) {
		
		List<UserImage> userImageList=userService.getProfileImage(userID);
		List<UserImage> userImageList1=new ArrayList<UserImage>();
		for(UserImage userImage:userImageList){
			//System.out.println(userImage.getImageID());
			//userImage.setUser(null);
			userImageList1.add(userImage);
			System.out.println(userImage.getProfileImage());
		}
		
		return userImageList1;
	}
    
    @RequestMapping(value="/userInterests", method=RequestMethod.GET)
    public @ResponseBody List<Interest> userinterests(@RequestParam("userID") int userID) {
    	List<UserInterest> userInterestList=userService.getUserInterests(userID);
    	
    	List<Interest> interestList=interestService.getInterests();
    	List<Interest> newInterestList=new ArrayList<Interest>();
    	
    	for(UserInterest userInterest:userInterestList){
    		//System.out.println("UserInterest"+userInterest.getInterestId());
    		for(Interest interest:interestList){
    			//System.out.println("Interest"+interest.getInterestId());
    			if(userInterest.getInterestId()==interest.getInterestId()){
    				//System.out.println("User interest id"+interest.getInterestId());
    				newInterestList.add(interest);
    			}
    		}
    	}
    	
    	
        //System.out.println(userService.getUserInterests(userID));
		return newInterestList; 
        
    }
}