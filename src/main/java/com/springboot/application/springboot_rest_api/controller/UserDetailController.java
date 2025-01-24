package com.springboot.application.springboot_rest_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application.springboot_rest_api.entity.UserDetail;
import com.springboot.application.springboot_rest_api.service.serviceImp.UserDetailService;

@RestController
@RequestMapping("/UserDetails")
public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;
	// Create or Update User
    @PostMapping("createUser")
    public ResponseEntity<UserDetail> createUser(@RequestBody UserDetail user) {
        UserDetail createdUserDetails = userDetailService.createUser(user);
        return new ResponseEntity<>(createdUserDetails, HttpStatus.CREATED);
    }

    // Get All Users
    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserDetail>> getAllUsers() {
        List<UserDetail> users = userDetailService.getUserDetails();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get User by ID
    @GetMapping("getUserById/{id}")
    public ResponseEntity<UserDetail> getUserById(@PathVariable Long id) {
        Optional<UserDetail> user = userDetailService.getUserDetailbyId(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update User
    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDetail> updateUser(@PathVariable Long id, @RequestBody UserDetail UpdateUser) {
    	userDetailService.updateUser(id,UpdateUser);
    	 return new ResponseEntity<>(UpdateUser, HttpStatus.OK);
    }

    // Delete User by ID
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userDetailService.deleteUserDetailbyid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
