package com.educational.material.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

@Component
public class SystemHelper {
	
	private String zoneId = "Asia/Kolkata";
	
	public boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public boolean isEmpty(Object obj) {
		return obj == null;
	}
	
	public ZoneId getZoneId() {
		return ZoneId.of(zoneId);
	}
	
	public LocalDateTime getCurrentTime() {
		return LocalDateTime.now().atZone(getZoneId()).toLocalDateTime();
	}
	
}
