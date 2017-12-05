package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings)  throws Exception{
        System.out.println("Loading data ...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user= new User("bob@bob.com","bob","Bob",true, "bob","pass");
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        userRepository.save(user);

        user= new User("jim@jim.com","jim","Jim",true, "jim","pass");
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        userRepository.save(user);

        user= new User("admin@adm.com","pass","admin",true, "admin","pass");
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        userRepository.save(user);

        user= new User("sam@ev.com","bob","Bob",true, "sam","pass");
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        userRepository.save(user);

    }
}
