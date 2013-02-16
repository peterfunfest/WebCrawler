package webcrawler;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Peter Hayes, Iain Ritchie
 * Interface providing basic utility methods for parsing HTML.
 */

public interface HTMLReader {

	/**
	 * Accepts an instance of an InputSteam and two char's as parameters. 
	 * Consumes characters from the InputStream and stops when either a character that 
	 * is the same as either of the other two parameters is encountered (ignoring case).
	 *  
	 * @param in InputStream to consume.
	 * @param ch1 First char to compare.
	 * @param ch2 Second char to compare.
	 * @return If the character is the same as ch1 the value true is returned; otherwise, false is returned. 
	 * @throws IOException
	 */
	public abstract boolean readUntil(InputStream in, char ch1, char ch2)
			throws IOException;

	/**
	 * Accepts an instance on InputStream and a char as parameters.
	 * Consumes up to and including the first non-whitespace character on the InputStream or up to and including the character parameter.
	 * 
	 * @param in InputStream to consume
	 * @param ch char to evaluate
	 * @return Smallest possible value of a char, if the method stopped reading characters because the char parameter was encountered.
	 * Otherwise returns the non-whitespace character that was read.
	 * @throws IOException
	 */
	public abstract char skipSpace(InputStream in, char ch) throws IOException;

	/**
	 * Accepts an instance of InputSteam and two chars as parameters. 
	 * Consumes characters on the InputSteam and stops when either a character that is the same as ch1 or ch2 is encountered, not ignoring case.
	 * @param in InputStream to consume.
	 * @param ch1 First char to compare.
	 * @param ch2 Second char to compare.
	 * @return String containing the characters that have been read in-order, if the character encountered is the same as the first char parameter.
	 * Otherwise if the terminating character was the same as the second char parameter, returns special String value null.
	 * @throws IOException
	 */
	public abstract String readString(InputStream in, char ch1, char ch2)
			throws IOException;

}