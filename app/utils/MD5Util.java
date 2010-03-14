package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(
					1, 3));
		}
		return sb.toString();
	}

	public static String md5Hex(String text) {
		String md5text = "";
		
		if (text == null || text.length() == 0)
			return md5text;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md5text = hex(md.digest(text.getBytes("CP1252")));
		} catch (NoSuchAlgorithmException e) {
			
		} catch (UnsupportedEncodingException e) {
			
		}
		
		return md5text;
	}
}
