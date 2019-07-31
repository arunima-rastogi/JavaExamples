package EncryptionDecryption_Utilities;

//import for EncryptionDecryption Utilities

public class Client {

	public static void main(String[] args) {
		GenerateKey obj = new GenerateKey();
		String enc = obj.encrypt("Sheetal");
		String dec = obj.decrypt(enc);

		System.out.println(enc);
		System.out.println(dec);

	}

}
