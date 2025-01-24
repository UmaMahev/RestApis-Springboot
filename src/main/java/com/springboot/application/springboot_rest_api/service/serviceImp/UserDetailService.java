package com.springboot.application.springboot_rest_api.service.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.internal.util.beans.BeanInfoHelper.ReturningBeanInfoDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.springboot_rest_api.entity.UserDetail;
import com.springboot.application.springboot_rest_api.repository.UserDetailRepository;

@Service
public class UserDetailService {
	@Autowired
	private UserDetailRepository userDetailRepository;

	public UserDetail createUser(UserDetail user) {
		System.out.println("createUserService");
		return userDetailRepository.save(user);
	}

	public List<UserDetail> createUsers(List<UserDetail> user) {
		Iterable<UserDetail> savedUsers = userDetailRepository.saveAll(user);
		List<UserDetail> userDetailsList = new ArrayList<>();
		savedUsers.forEach(userDetailsList::add);
		return userDetailsList;
	}
	public List<UserDetail> getUserDetails(){
		System.out.println("getUserDetails getUserDetails getUserDetails");
		Iterable<UserDetail> getUsersIterable = userDetailRepository.findAll();
		return StreamSupport.stream(getUsersIterable.spliterator(), false)
                .collect(Collectors.toList());
	}
	public Optional<UserDetail> getUserDetailbyId(Long id){
		return userDetailRepository.findById(id);
	}
	public  void deleteUserDetailbyid(Long id) {
		        if (userDetailRepository.existsById(id)) {
		            userDetailRepository.deleteById(id);
		        } else {
		            throw new RuntimeException("User with ID " + id + " not found");
		        }
		    }
	 public UserDetail updateUser(Long id, UserDetail updatedUserDetails) {
	        if (userDetailRepository.existsById(id)) {
	        		            return userDetailRepository.save(updatedUserDetails);
	        }
			return updatedUserDetails;
}}