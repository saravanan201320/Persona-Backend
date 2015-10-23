package com.creative.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.creative.dao.InterestDAO;
import com.creative.model.Interest;
 
@RestController
@RequestMapping("/service")
public class InterestService {
	@Autowired
	
	private InterestDAO interestDAO=new InterestDAO();
    
    @RequestMapping(value="/interests/", method=RequestMethod.GET)
    public List<Interest> interests() {
    	System.out.println("-----------" + interestDAO.getInterests());
        return interestDAO.getInterests();
    }
     
    @RequestMapping(value="/interest/", method=RequestMethod.GET)
    public Interest interest(HttpServletRequest request) {
        if(request.getParameter("category")!=null)
        {
        return interestDAO.getInterest(Integer.parseInt(request.getParameter("category")));
        }
        return null;
    }
}