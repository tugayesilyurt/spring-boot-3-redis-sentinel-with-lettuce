package com.redis.sentinel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redis.sentinel.request.AddRedisRequest;
import com.redis.sentinel.service.RedisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/redis")
@RequiredArgsConstructor
public class RedisController {

	private final RedisService redisService;

	@PostMapping("/add")
	public ResponseEntity<?> addRedisKeyValue(@RequestBody AddRedisRequest redisRequest){

		redisService.addRedis(redisRequest);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<?> getFromCache(@RequestParam(value = "key") String key) throws JsonProcessingException {

		String value = redisService.getValue(key);
		return new ResponseEntity<String>(value, HttpStatus.OK);
	}

}
