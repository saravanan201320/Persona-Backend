package com.creative.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.creative.model.Interest;

@RestController
@RequestMapping("/service")
public class InterestController {
	@Autowired
	private InterestService interestService;
    
    @RequestMapping(value="/interests", method=RequestMethod.GET)
    public @ResponseBody List<Interest> interests() {
        return interestService.getInterests();
    }
     
//    @RequestMapping(value="/interest", method=RequestMethod.GET)
//    public Interest interest(HttpServletRequest request) {
//        if(request.getParameter("category")!=null)
//        {
//        return interestService.getInterest(Integer.parseInt(request.getParameter("category")));
//        }
//        return null;
//    }
}