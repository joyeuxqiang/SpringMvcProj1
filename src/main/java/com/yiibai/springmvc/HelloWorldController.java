package com.yiibai.springmvc;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        System.out.print("hello wolrd"); 
        return"helloworld";
         
    }
    
    @RequestMapping("/test")
    public String requestResponseExample(HttpServletRequest request,
            HttpServletResponse reponses, Model model) {
  
        // Todo something here
        System.out.print("in test");
        return "helloworld";
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String authorInfo(Model model) {
 
       // Do somethong here
    	System.out.print("in redirect");
        return "redirect:/hello";
    }
    
    
    
    @RequestMapping("/user")
    public String userInfo(Model model,
    @RequestParam(value = "name", defaultValue = "Guest") String name) {
 
        model.addAttribute("name", name);
 
        if("admin".equals(name)) {
            model.addAttribute("email", "admin@yiibai.com");
        } else{
            model.addAttribute("email", "Not set");
        }
        return "userInfo";
    }
    
    
    @RequestMapping("/web/fe/{sitePrefix}/{language}/document/{id}/{naturalText}")
    public String documentView(Model model,
            @PathVariable(value = "sitePrefix") String sitePrefix,
            @PathVariable(value = "language") String language,
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "naturalText") String naturalText) {
    	//System.out.print("in document");
        model.addAttribute("sitePrefix", sitePrefix);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        model.addAttribute("naturalText", naturalText);
 
        String documentName = "Java tutorial for Beginners";
        if(id == 8108) {
            documentName = "Spring MVC for Beginners";
        }
 
        model.addAttribute("documentName", documentName);
        System.out.print(documentName);
        return "documentView";
    }
    
    // Simple example, method returns String.
    @RequestMapping(value = "/saveResult")
    @ResponseBody
    public String authorInfoR(Model model) {
        return "saved";
    }
    
}