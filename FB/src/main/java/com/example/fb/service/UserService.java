package com.example.fb.service;

import com.example.fb.module.User;

public interface UserService {
   User addUser(User u);
   Object login(String UsernameOrEmail,String password);
}
