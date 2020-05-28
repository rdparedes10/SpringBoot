/**
 * 
 */
package com.todo1.puce.utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

/**
 * @author rparedes
 *
 */
public class Utils {

	/**
	 * CREATE SESSION ID
	 * @return - return token
	 */
	public static String createSessionId() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		String token = encoder.encodeToString(bytes);
		return token;

	}

	/**
	 * GENERATE COD
	 * @return - RandCOD
	 */
	public static String generateCod() {
		SecureRandom rand = new SecureRandom();
		int rand_int = rand.nextInt(100000);
		return rand_int + "";
	}
	
	/**
	 * GENERATE COD
	 * @return - RandCOD
	 */
	public static int randomNumberLength(int length) {
		 Random rand = new Random(); 
	     int int_random = rand.nextInt(length); 
	     return int_random;
	}
	
	
	
}
