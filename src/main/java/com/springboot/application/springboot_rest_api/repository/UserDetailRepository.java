package com.springboot.application.springboot_rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.springboot.application.springboot_rest_api.entity.UserDetail;
@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Long>{

}
