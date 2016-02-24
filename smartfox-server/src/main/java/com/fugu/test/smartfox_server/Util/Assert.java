package com.fugu.test.smartfox_server.Util;

public class Assert {
	
	public static void isSingleChar(String str) {
		if (str.toCharArray().length != 1) {
			throw new IllegalArgumentException("String must be a single char.");
		}
	}
	
}
