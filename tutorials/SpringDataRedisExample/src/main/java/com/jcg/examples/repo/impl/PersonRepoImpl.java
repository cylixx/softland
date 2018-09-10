package com.jcg.examples.repo.impl;

import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;

import com.jcg.examples.bean.Person;
import com.jcg.examples.repo.PersonRepo;

public class PersonRepoImpl implements PersonRepo {

	private RedisTemplate<String, Person> redisTemplate;

	private static String PERSON_KEY = "Person";
	

	public RedisTemplate<String, Person> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Person> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void save(Person person) {
		this.redisTemplate.opsForHash().put(PERSON_KEY, person.getId(), person);
	}

	@Override
	public Person find(String id) {
		return (Person) this.redisTemplate.opsForHash().get(PERSON_KEY, id);
	}

	@Override
	public Map<Object, Object> findAll() {
		return this.redisTemplate.opsForHash().entries(PERSON_KEY);
	}

	@Override
	public void delete(String id) {
		this.redisTemplate.opsForHash().delete(PERSON_KEY, id);

	}

}
