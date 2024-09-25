package com.springreact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springreact.model.User;
import com.springreact.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;


    public int login(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && user.getPassword().equals(existingUser.getPassword())) {
        	return 1;        
        } 
        
        else if(existingUser == null) {
    		return 2;
    	}   
        
        else {
            return 3;
        }
    }
 

}