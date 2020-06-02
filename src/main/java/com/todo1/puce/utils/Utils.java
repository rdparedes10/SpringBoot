/**
 * 
 */
package com.todo1.puce.utils;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author rparedes
 *
 */
public class Utils {

	private final static String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDN3Fp6Lpu3/EgCFix0V1brYIZOlFf4ZehmTOq9t/mg7HDjAoQ2MVfsuyplfF0V+hHETAf3TNkcseCw0XNd7cmqJFpsgNw1mYpLYXQDv4zCvHorZ9nlvsTZ9IsVsLsWy8vbaY3Qo0Cnfm10AOmXiUqo0W4Xs1PbZkGn9fedyh3xwO8xv22XSGJDWEm/QfwzL/fXD4X4J1q3/0lrl3XO045gjHWZnYUPabYzff8GAZj8G6xQqpKT1b3USH3360dLmhO8TwIjyDum+FC16qZWAFsk5rvd5CFl85AnRpZDmbaLQ1Q9ybC8YPNRFdMpb7vZQoPPrvVsTtgByHYf5TtRB5rDAgMBAAECggEAUDPieCnCd1rtvwpehXElpwxzJxg6ccdaVMjwx7tuoRidHoRzeB2fUNbWvLVIGvDTjTPGAr5I9BoFHT5tARJMeGIzbISDxsosDBRKu88cCx6dRl3ukcjSLsxMh8XUDhyWLsSgAMIpxVfHUuOsHmLZ2I3Ho6o1KIxdVg/JSgtdwTqjz3w8jmGQ/NXgc7Ym/ys1fLG9L2nYdMzK/mRJf/BnXiCNE6/SYlZYO716oC688UJBWS3BqB9jaJyNpigX//ynJvU6xw8FhHt4fRStUmCCYAYhCQu3XgbtmxKisDGhdBVASG+DM+vVTh+sSvxkNrjJjF+m2tSg578A8C8Ls0r3uQKBgQDpO9e178NR0HHmvWbZR9+uPugf4UT9+U2/dEfJBHAOp2GRsIvXkFwbPHuSHkc0iEPwz+U8gPC8jInSslKOUDtaGtUaVzzWrxxh7DggWx4pYs3I0Ki8C+CRTTdOY9GAFa9jhIyRmf6v9QoAH/loGNV2qYFbb+HweD0PnxlWha1txQKBgQDh9IBBltW7T96foUmHOn+x6xlF5MNDHxLBY6bngxKvMTZoi5C6wmmCmasF45LWbkvUiMAsovYN5z4cJnKXWmRmCS8NXUucmUgdvsmCbiB62BmZvHaOffmnIdhcAjBebT/Bn5qMvKCNy3fQFSfuEw1eRRO2IofB4o7z7m794vo25wKBgEPowrQcrZhCwwdWGn4laUGI23l80+PHFRYru0MSYbZCkiwjZXRMeiUMBUbUPhNTocSaI7rsKCweF3sbpOH/BmkD6wySXgp8Th1M9EKnhS6zsAtKhfbK1oY4H2RZuAQ9TCYD0BIM7pU5GcJTjQD8ShsU269N8lFcERtdTbldjtOpAoGAF4YkADAa6lhjXg0loY2Gk9hdFji913QZuMaOLtYnkNO3zWSSWc85ut4Svxc1R1vOSz89eqgwo7vqbHXYQken4jOckXCgGZqftnERe6HJgeCTsby8PxOAdVUBuHqF3J7VH2xlY7eTo4+GVsSNFq0nHCRm6/RmW9ohdeXh6k7CLAsCgYBZe3RLWuffKxg+lZmv9tJDOO813QPLFeixrBYhKjGDcwjVYcCugGNDmyStM0/++uWddgMKavNALjpamu8KolDNivrjL1qaFHX9Bpi108T+dDn2WpX+vUP6hjA/U2wtTvUbJle1SsbZxRrV9gf5PAJqTrQY4u28ezjR3PCV+R4kdw==";

	/**
	 * CREATE SESSION ID
	 * 
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
	 * 
	 * @return - RandCOD
	 */
	public static String generateCod() {
		SecureRandom rand = new SecureRandom();
		int rand_int = rand.nextInt(100000);
		return rand_int + "";
	}

	/**
	 * GENERATE COD
	 * 
	 * @return - RandCOD
	 */
	public static int randomNumberLength(int length) {
		Random rand = new Random();
		int int_random = rand.nextInt(length);
		return int_random;
	}

	/**
	 * SET PRIVATE KEY STRING
	 * 
	 * @param key - Private Key
	 * @throws NoSuchAlgorithmException - Exception
	 * @throws InvalidKeySpecException - Exception
	 */
	public PrivateKey setPrivateKeyString(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key.getBytes()));
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}

	/**
	 * DECRYPT
	 * @param result - encrypt text
	 * @return - Return Decrypt text
	 * @throws NoSuchAlgorithmException - Exception
	 * @throws NoSuchPaddingException - Exception
	 * @throws InvalidKeyException - Exception
	 * @throws IllegalBlockSizeException - Exception
	 * @throws BadPaddingException - Exception
	 * @throws InvalidKeySpecException - Exception
	 */
	public String decrypt(String result) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, setPrivateKeyString(PRIVATE_KEY));
        return new String(cipher.doFinal(Base64.getDecoder().decode(result.getBytes())));
	}

}
