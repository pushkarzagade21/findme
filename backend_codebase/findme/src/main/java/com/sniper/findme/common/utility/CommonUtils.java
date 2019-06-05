package com.sniper.findme.common.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class CommonUtils {
	public static final boolean isEmptyOrNull(Object object) {
		if (null == object) {
			return true;
		} else {
			return false;
		}
	}

	public static final String encryptData(String decryptedString) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(decryptedString);
	}

	public static final boolean decryptData(String rawPassword, String encryptedString) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encryptedString);
	}
}
