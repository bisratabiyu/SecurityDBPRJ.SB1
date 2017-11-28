package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/login")
    public String login()
    {

        return "login";
    }
    @RequestMapping("/secure")
    public String secure()
    {
        return "secure";
    }
}
