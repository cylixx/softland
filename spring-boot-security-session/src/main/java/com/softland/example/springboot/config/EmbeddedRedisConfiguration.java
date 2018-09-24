package com.softland.example.springboot.config;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.Protocol;

@Configuration
@EnableRedisHttpSession
public class EmbeddedRedisConfiguration {
//    private static RedisServer redisServer;
//
//    @Bean
//    public JedisConnectionFactory connectionFactory() throws IOException {
//        //redisServer = new RedisServer(Protocol.DEFAULT_PORT);
//    	redisServer = new RedisServer("127.0.0.1", Protocol.DEFAULT_PORT);
//        redisServer.start();
//        return new JedisConnectionFactory();
//    }
//
//    @PreDestroy
//    public void destroy() {
//        redisServer.stop();
//    }
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}
}
