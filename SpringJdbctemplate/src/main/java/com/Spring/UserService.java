package com.Spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired  // creates object for specified class
private UserRepository userrepo;
	//CRUD
	
    // creating new User
	 public void createUser(Users user) {
		userrepo.createUser(user);
	 }
	 
	 //fetching all users
	 public List<Users> getAllUsers(){
		 return userrepo.getAllUsers();
		 
	 }
	 
	 //fetching user by ID
     public Users getUserById(int id) {
    	 return userrepo.fetchUserById(id);
     }
     
   //fetching user by ID and Name
     public void UpdateUserById(int id,String name) {
    	 userrepo.UpdateUserById(id,name);
     }
     
     //delete the user
      public void deleteUserById(int id) {
    	   userrepo.deleteUserById(id);
      }
}
