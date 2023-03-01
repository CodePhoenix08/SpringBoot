package com.example.fb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fb.module.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	@Query(value="select * from user where username=?1 or email=?2",nativeQuery=true)
	User findByUsernameorEmail(String username,String email);
	
}
