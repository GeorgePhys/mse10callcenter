package callcenter.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordHashUtil {

	private PasswordHashUtil() {
	}

	/**
	 * Converts to string.
	 * 
	 * @param data
	 *            Byte array to convert.
	 * @return the hashed string.
	 */
	private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	/**
	 * Creates a string hash using {@link MessageDigest}.
	 * 
	 * @param text
	 *            String to hash.
	 * @return The hashed string.
	 * @throws NoSuchAlgorithmException
	 *             If the algorithm used is not supported.
	 * @throws UnsupportedEncodingException
	 *             If the used encoding is not supported.
	 */
	public static String getPasswordHash(String text)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		byte[] hash = new byte[40];
		md.update(text.getBytes("UTF-8"), 0, text.length());
		hash = md.digest();
		return convertToHex(hash);
	}
}
