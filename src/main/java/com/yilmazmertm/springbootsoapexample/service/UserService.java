package com.yilmazmertm.springbootsoapexample.service;

import com.yilmazmertm.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize(){
        User userPeter = new User();
        userPeter.setName("Peter");
        userPeter.setEmpId(11);
        userPeter.setSalary(3000);
        users.put(userPeter.getName(), userPeter);

        User userMert = new User();
        userMert.setName("Mert");
        userMert.setEmpId(22);
        userMert.setSalary(5000);
        users.put(userMert.getName(), userMert);
    }

    public User getUsers(String name){
        return users.get(name);
    }
}
