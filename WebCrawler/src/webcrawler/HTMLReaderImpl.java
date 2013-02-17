
package webcrawler;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Peter Hayes, Iain Ritchie Implementation of the HMTLReader Interface
 */

public class HTMLReaderImpl implements HTMLReader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)
	 */
	public boolean readUntil(InputStream in, char ch1, char ch2)
			throws IOException {

		// I think I have fixed the case sensitivity issue but it is still failing the following test case:
		// ch1 and ch2 are the same; and are present in the input stream. I would expect 
		// this method to return false but it is not.
		
		char ch1LowerCase = Character.toLowerCase(ch1);
		char ch2LowerCase = Character.toLowerCase(ch2);

		int b;
		char charToCompare;

		do {
			b = in.read();
			charToCompare = (char) Character.toLowerCase(b);
			//System.out.println("Char to Compare = " + charToCompare);
			//System.out.println("Char 1 LC = " + ch1LowerCase);
			//System.out.println("Char 2 LC = " + ch2LowerCase);

		} while (b >= 0 && charToCompare != ch1LowerCase
				&& charToCompare != ch2LowerCase);
		return (charToCompare == ch1LowerCase);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)
	 */
	public char skipSpace(InputStream in, char ch) throws IOException {

		int b;

		do {
			b = in.read();
		} while (b >= 0 && b != ch && Character.isWhitespace(ch));

		return (b == ch ? Character.MIN_VALUE : (char) b);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.HTMLReader#readString(java.io.InputStream, char, char)
	 */
	public String readString(InputStream in, char ch1, char ch2)
			throws IOException {

		int b;
		StringBuilder sb = new StringBuilder();

		do {
			b = in.read();
			sb.append((char) b);
		} while (b >= 0 && b != ch1 && b != ch2);

		return ((b == ch1 || b == -1) ? sb.toString() : null);

	}

}