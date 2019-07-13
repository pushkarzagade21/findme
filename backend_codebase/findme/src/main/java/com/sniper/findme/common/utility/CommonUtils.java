package com.sniper.findme.common.utility;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonUtils.
 */
public final class CommonUtils {

	/**
	 * Checks if is empty or null.
	 *
	 * @param object the object
	 * @return true, if is empty or null
	 */
	public static final boolean isEmptyOrNull(Object object) {
		if (null == object) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if is list empty or null.
	 *
	 * @param list the list
	 * @return true, if is list empty or null
	 */
	public static final boolean isListEmptyOrNull(List list) {
		if (null == list) {
			return true;
		} else if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Encrypt data.
	 *
	 * @param decryptedString the decrypted string
	 * @return the string
	 */
	public static final String encryptData(String decryptedString) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(decryptedString);
	}

	/**
	 * Decrypt data.
	 *
	 * @param rawPassword     the raw password
	 * @param encryptedString the encrypted string
	 * @return true, if successful
	 */
	public static final boolean decryptData(String rawPassword, String encryptedString) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encryptedString);
	}
}
