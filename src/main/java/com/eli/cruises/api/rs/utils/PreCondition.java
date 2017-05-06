package com.eli.cruises.api.rs.utils;

import com.eli.cruises.api.errors.NotFoundException;

public class PreCondition {

	 public static <T> T checkNotNull(String err, T resource) {
		
		if (null==resource) throw new IllegalArgumentException(err);
		
		return resource;
	}


	 public static <T> T checkNotFound(String err, T resource) {
		
		if (null==resource) throw new NotFoundException(err);
		
		return resource;
	}


}
