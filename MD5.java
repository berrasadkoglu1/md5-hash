package rsa.java;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Java program to calculate MD5 hash value
public class MD5 {
	public static String getMd5(String input)
	{
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	// Driver code
	public static void main(String args[]) throws NoSuchAlgorithmException
	{
		
		  String text="HTTP ( Hyper-Text Transfer Protocol in English , " +
		  "Hyper -Text Transfer Protocol in Turkish ) is an application-level " +
		  "communication protocol for hypermedia information systems that are " +
		  "distributed from a source and open to common use . " +
		  "[1] HTTP is the basis of data communication for the World Wide Web ;" +
		  "where hypertext documents contain hyperlinks to other resources " +
		  "that the user can easily access, for example, with a mouse click or" +
		  " tapping the screen in a web browser. HTTP was developed by Tim Berners-Lee"
		  + " at CERN in 1989.";
		 

		System.out.println(text.length());
		String copyText;
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != 'x') {
				copyText = text.substring(0, i) + 'x' + text.substring(i + 1);
			} else
				copyText = text.substring(0, i) + 'y' + text.substring(i + 1);
			System.out.println(i+" "+getMd5(copyText));

		}
	

	}

		
}
