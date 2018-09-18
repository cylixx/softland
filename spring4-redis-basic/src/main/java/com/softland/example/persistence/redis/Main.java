package com.softland.example.persistence.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Main {
	public static void main(String[] args) {
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	       ctx.register(RedisConfig.class);
	       ctx.refresh();
	       StringRedisTemplate stringRedisTemplate  = ctx.getBean(StringRedisTemplate.class);
	       // Using set to set value
	       stringRedisTemplate.opsForValue().set("R", "Ram");
	       stringRedisTemplate.opsForValue().set("S", "Shyam");
	       //Fetch values from set
	       System.out.println(stringRedisTemplate.opsForValue().get("R"));
	       System.out.println(stringRedisTemplate.opsForValue().get("S"));
	       //Using Hash Operation
	       String mohan = "Mohan";
	       stringRedisTemplate.opsForHash().put("M", String.valueOf(mohan.hashCode()),mohan);
	       System.out.println(stringRedisTemplate.opsForHash().get("M", String.valueOf(mohan.hashCode())));
    }
}
