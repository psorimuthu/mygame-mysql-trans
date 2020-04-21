package com.pad.mysql.demo.repo;

import com.pad.mysql.demo.data.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

}