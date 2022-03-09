package com.abc.usersprint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.usersprint.model.Category;
import com.abc.usersprint.model.Details;
import com.abc.usersprint.model.User;
import com.abc.usersprint.service.CategoryService;
import com.abc.usersprint.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User newUser = userService.addUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser,HttpStatus.CREATED);
		return responseEntity;
				
	}
	
	@GetMapping("/get/{usid}")
	public ResponseEntity<?> fetchUserDetails(@PathVariable("usid") int userId) {
		Details user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable("uid") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted with id: "+userId, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}	
	
	@GetMapping("/getbyid/{idproof}")
	public ResponseEntity<?> fetchUserByIdproof(@PathVariable("idproof") String idProof) {
		User user = userService.getUserByIdproof(idProof);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getbycategoryname/{categoryname}")
	public Category fetchCategoryByUserId(@PathVariable("categoryname") String categoryName){
		Category category = categoryService.getCategoryDetails(categoryName);
		return category;
	}
	
	@GetMapping("/getbyuserid/{id}")
	public ResponseEntity<?> fetchUser(@PathVariable("id") int userId) {
		User user = userService.getUserDetails(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
