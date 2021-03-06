package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    UserValidator userValidator;
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @RequestMapping("/")
    public String index()
    {
        return "index2";
    }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/403")
    public String error403() {
        return "Error403";
    }
    @RequestMapping("/secure")
    public String secure()
    {
        try{
            return "secure";
        }catch(Exception ex)  {
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String getregister(Model model)
    {
        model.addAttribute("user",new User());
        return "registration";
    }
    @PostMapping ("/register")
    public String postregister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
    {
        userValidator.validate(user,result);
        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        }else{
            userService.saveUser(user);
        }
        return "index";

    }


}



