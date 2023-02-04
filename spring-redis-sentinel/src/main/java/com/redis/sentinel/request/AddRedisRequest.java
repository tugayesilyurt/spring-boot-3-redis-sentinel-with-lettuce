package com.redis.sentinel.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRedisRequest {
	
	private String key;
	private String value;
	private Integer expireMinutes;

}
