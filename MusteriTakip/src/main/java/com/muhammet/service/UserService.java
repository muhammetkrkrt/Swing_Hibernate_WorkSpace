package com.muhammet.service;

import com.muhammet.entity.User;
import com.muhammet.repository.UserRepository;
import com.muhammet.utility.MyFactoryService;

public class UserService extends MyFactoryService<User, UserRepository>{       
    public UserService(){
        super(new UserRepository());
    }    
    public boolean isUser(String username, String password){
         return repository.isUser(username, password);
    }    
}