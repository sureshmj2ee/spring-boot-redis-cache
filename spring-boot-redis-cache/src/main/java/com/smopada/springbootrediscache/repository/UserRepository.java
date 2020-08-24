package com.smopada.springbootrediscache.repository;

import org.springframework.data.repository.CrudRepository;

import com.smopada.springbootrediscache.model.User;

public interface UserRepository  extends CrudRepository<String, User>{
}
