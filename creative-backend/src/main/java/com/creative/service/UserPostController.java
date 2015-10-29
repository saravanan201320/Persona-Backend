package com.creative.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.creative.model.UpdateDetails;
import com.creative.model.UserPost;
import com.creative.model.UserPostImage;

@RestController
@RequestMapping("/service")
public class UserPostController {
	@Autowired
	private UserPostService userPostService;
	
	List<MultipartFile> multiFiles=new ArrayList<MultipartFile>();
	List<String> filePathList=new ArrayList<String>();
	
		@RequestMapping(value="/attachmentFile", method=RequestMethod.POST)
		public void attachmentFile(HttpServletRequest request,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
			System.out.println("file----->"+file);
	    	
	    	 String distPath=request.getContextPath().toString();
	    	 String filePath=distPath+"/temp/"+file.getOriginalFilename();
			if (!file.isEmpty()) {
				//bytes = file.getBytes();
                 File tempFile=new File (distPath+"/temp/", file.getOriginalFilename());
                 filePathList.add(filePath);
				multiFiles.add(file);
			}
			 
	           
			System.out.println(multiFiles);
	        //System.out.println(String.format("receive %s from %s", file.getOriginalFilename()));
		}
	
		@RequestMapping(value="/postAd", method=RequestMethod.POST)
	    public @ResponseBody ResponseEntity<String> saveUserPost(HttpServletRequest request,UserPost userPost,@RequestParam("Category") String Category,@RequestParam("Sub_Category") String Sub_Category,
	    		@RequestParam("userName") String userName,@RequestParam("userId") Integer userId,
	    		@RequestParam("description") String description) throws IllegalStateException,IOException {
		 System.out.println("FILES----------->"+multiFiles);
		 
		 
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
			 userPost.setUserId(userId);
			 userPost.setDescription(description);
		 List<UserPostImage> userPostImageList=new ArrayList<UserPostImage>();
		 String distPath=request.getContextPath().toString();
		 System.out.println("File Length----------->"+multiFiles.size());
		 for(MultipartFile file:multiFiles){
			 System.out.println("file-----------=>"+file);
			// System.out.println("file-----------=>"+file.getOriginalFilename());
			 UserPostImage userPostImage= new UserPostImage();
			 //String distPath=request.getContextPath().toString();
			 //System.out.println("distPath"+distPath);
			
			 if (!file.isEmpty()) {
				 byte[] bytes=null;
				  System.out.println("bytes----------->"+file.getOriginalFilename());
				 bytes=file.getBytes();
				 // File tempFile=new File (distPath+"/temp/", file.getOriginalFilename());
				 //  file.transferTo(tempFile);
					// FileInputStream in=new FileInputStream(filePath);
				 
					
					userPostImage.setImage(bytes);
					userPostImage.setUserPost(userPost);
					userPostImageList.add(userPostImage);
					
				}
		 }
		 
//	 System.out.println("File Length----------->"+files.length);
//		 for (int i=0;i<files.length;i++){
//			 System.out.println("files-----------=>"+files[i].getOriginalFilename());
//			 UserPostImage userPostImage= new UserPostImage();
//			 byte[] bytes;
//			 if (!files[i].isEmpty()) {
//				 bytes = files[i].getBytes();
//				 System.out.println("bytes----------->"+bytes);
//				 userPostImage.setImage(bytes);
//				 userPostImageList.add(userPostImage);
//			 }
//		 }
		 userPost.setUserPostImage(userPostImageList);
		 
		
		System.out.println("userPostImageList----------->"+userPostImageList);
		 System.out.println("Category----------->"+Category);
		 System.out.println("Sub_Category----------->"+Sub_Category);
		 System.out.println("userName----------->"+userName);
		 System.out.println("userId----------->"+userId);
		 System.out.println("description----------->"+description);
		System.out.println("files----------->"+userPost.getUserPostImage());
	    userPostService.saveUserPost(userPost);
		 
		 multiFiles.clear();
		return null;
	    }
		
		@RequestMapping(value="/postedAd", method=RequestMethod.GET)
	    public @ResponseBody List<UserPost> userDetail() {
	    	//System.out.println("----------->" +userService.getUsers(emailId, password));	
			List<UserPost> userPostList=userPostService.getUserPosts();
			for(UserPost userPost:userPostList){
				for(UserPostImage postImage:userPost.getUserPostImage()){
					postImage.setUserPost(null);
				}
			}
	       return userPostList;
	    }
	
}
