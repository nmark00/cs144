import java.io.*;
import java.security.*;

public class ComputeSHA
{
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		byte[] buffer = new byte[(int) file.length()];
		
		FileInputStream line = new FileInputStream(file);
		line.read(buffer);
		line.close();

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(buffer);
		byte[] hashed = md.digest();

		StringBuilder hexed = new StringBuilder(2 * hashed.length);

		for (int i = 0; i < hashed.length; i++) {
			String hex = Integer.toHexString(0xff & hashed[i]);
			if (hex.length() == 1) {
				hexed.append('0');
			}
			hexed.append(hex);
		}

		System.out.println(hexed.toString());
	}
}
