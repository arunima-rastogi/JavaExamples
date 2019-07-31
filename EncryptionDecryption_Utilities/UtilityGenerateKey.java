package EncryptionDecryption_Utilities;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class UtilityGenerateKey {

	/*
	 * <dependencies> 
	 *   <dependency> <groupId>commons-codec</groupId>
	 *     <artifactId>commons-codec</artifactId> <version>1.13</version> 
	 *   </dependency>
	 * </dependencies>
	 * 
	 */
	private String algorithm = "AES";
	private byte[] key = null;

	public GenerateKey() {
		this.key = GenKey();
	}

	public byte[] GenKey() {
		KeyGenerator gen = null;
		try {
			gen = KeyGenerator.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No such algorithm");
		}
		gen.init(128); /* 128-bit AES */
		SecretKey secret = gen.generateKey();
		byte[] binary = secret.getEncoded();
		String text = String.format("%032X", new BigInteger(+1, binary));
		byte[] key = text.getBytes();
		return key;
	}

	public String encrypt(String data) {
		key = GenKey();

		byte[] dataToSend = data.getBytes();
		Cipher c = null;
		try {
			c = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.out.println("No such algorithm");
		}
		SecretKeySpec k = new SecretKeySpec(key, algorithm);
		try {
			c.init(Cipher.ENCRYPT_MODE, k);
		} catch (InvalidKeyException e) {
			System.out.println("Invalid Key exception.....");
		}
		byte[] encryptedData = "".getBytes();
		try {
			encryptedData = c.doFinal(dataToSend);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			System.out.println("Illegal block size exception");
		}
		byte[] encryptedByteValue = new Base64().encode(encryptedData);
		return new String(encryptedByteValue);// .toString();
	}

	public String decrypt(String data) {

		byte[] encryptedData = new Base64().decode(data);
		Cipher c = null;
		try {
			c = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.out.println("No such algorithm");
		}
		SecretKeySpec k = new SecretKeySpec(key, algorithm);
		try {
			c.init(Cipher.DECRYPT_MODE, k);
		} catch (InvalidKeyException e1) {
			System.out.println("Invalid key exception");
		}
		byte[] decrypted = null;
		try {
			decrypted = c.doFinal(encryptedData);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			System.out.println("No such algorithm");
		}
		return new String(decrypted);
	}

}