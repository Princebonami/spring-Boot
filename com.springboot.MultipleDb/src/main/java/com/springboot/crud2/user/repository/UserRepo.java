package com.springboot.crud2.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud2.model.user.User;



@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

}
