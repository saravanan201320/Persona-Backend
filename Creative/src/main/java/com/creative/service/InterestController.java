package com.creative.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.creative.model.Interest;

@Controller
public class InterestController {
	@Autowired
	private InterestService interestService;
    
    @RequestMapping(value="/interests/", method=RequestMethod.GET)
    public List<Interest> interests() {
    	System.out.println("-----------" + interestService.getInterests());
        return interestService.getInterests();
    }
     
    @RequestMapping(value="/interest/", method=RequestMethod.GET)
    public Interest interest(HttpServletRequest request) {
        if(request.getParameter("category")!=null)
        {
        return interestService.getInterest(Integer.parseInt(request.getParameter("category")));
        }
        return null;
    }
}
