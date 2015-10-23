package com.creative.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.creative.model.Interest;


import com.creative.dao.InterestDAO;

@RestController
public class InterestService {

	private InterestDAO interestdao=new InterestDAO();
    
    @RequestMapping(value="/students", method=RequestMethod.GET)
    @ResponseBody 
    public List<Interest> students() {
        return interestdao.getInterests();
    }
     
     
    @RequestMapping(value="/student", method=RequestMethod.GET)
    @ResponseBody
    public Interest student(HttpServletRequest request) {
        if(request.getParameter("category")!=null)
        {
        return interestdao.getInterest(Integer.parseInt(request.getParameter("category")));
        }
        return null;
    }
}