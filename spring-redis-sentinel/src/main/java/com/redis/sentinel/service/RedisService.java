package com.redis.sentinel.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.redis.sentinel.request.AddRedisRequest;
import com.redis.sentinel.util.RedisUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RedisService {

	private final RedisUtil<String> redisStringUtil;

	public void addRedis(AddRedisRequest request) {
		redisStringUtil.putValue(request.getKey(), request.getValue());
		redisStringUtil.setExpire(request.getKey(), request.getExpireMinutes(), TimeUnit.MINUTES);
	}

	public String getValue(String key) {

		String value = redisStringUtil.getValue(key);
		return value;
	}

}