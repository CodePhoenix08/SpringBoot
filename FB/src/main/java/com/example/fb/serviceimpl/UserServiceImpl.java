package com.example.fb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fb.exception.ResourceNotFoundException;
import com.example.fb.module.User;
import com.example.fb.repository.UserRepo;
import com.example.fb.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;

	@Override
	public User addUser(User u) {
		
		return repo.save(u);
	}

	@Override
	public Object login(String UsernameOrEmail, String password) {
		User u=repo.findByUsernameorEmail(UsernameOrEmail, UsernameOrEmail);
		if(u!=null) {
			if(password.equals(u.getPassword())) {
				return u;
			}
			
			else {
				try {
					throw new ResourceNotFoundException("User","USernameOrEmail",UsernameOrEmail);
				}
				catch(ResourceNotFoundException e){
					return e.getMessage();
				}
			}
		}
		else {
			try {
				throw new ResourceNotFoundException("User","USernameOrEmail",UsernameOrEmail);
			}
			catch(ResourceNotFoundException e){
				return e.getMessage();
			}
		}
	
	}

}














