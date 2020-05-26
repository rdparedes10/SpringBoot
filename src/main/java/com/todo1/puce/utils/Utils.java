/**
 * 
 */
package com.todo1.puce.utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * @author rparedes
 *
 */
public class Utils {

	public static String createSessionId() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		String token = encoder.encodeToString(bytes);
		return token;

	}
}
