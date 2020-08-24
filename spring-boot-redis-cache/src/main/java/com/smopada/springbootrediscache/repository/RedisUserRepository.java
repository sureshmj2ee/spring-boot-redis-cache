package com.smopada.springbootrediscache.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.smopada.springbootrediscache.model.User;

@Repository
public class RedisUserRepository {

	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;

	public RedisUserRepository(RedisTemplate redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash();
	}

	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	public User findById(Integer id) {
		return (User) hashOperations.get("USER", id);
	}

	public List<User> findAll() {
		return hashOperations.values("USER");
	}
	
	public void update(User user) {
		save(user);
	}

	public void delete(Integer userId) {
		hashOperations.delete("USER", userId);
	}
	
	public void multiGetUsers(List<String> userIds) {
		hashOperations.multiGet("USER", userIds);
	}
	
}
