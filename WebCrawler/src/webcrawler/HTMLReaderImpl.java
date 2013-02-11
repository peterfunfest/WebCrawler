package webcrawler;

import java.io.IOException;
import java.io.InputStream;

public class HTMLReaderImpl implements HTMLReader {

	/* (non-Javadoc)
	 * @see webcrawler.HTMLReader#readUntil(java.io.InputStream, char, char)
	 */
	//@Override
	public boolean readUntil(InputStream in, char ch1, char ch2) throws IOException {
		
		int b;

		do {
			b = in.read();
		} while (b>=0 && b!=ch1 && b!=ch2);

		return (b==ch1);
		
	}
	
	/* (non-Javadoc)
	 * @see webcrawler.HTMLReader#skipSpace(java.io.InputStream, char)
	 */
	//@Override
	public char skipSpace(InputStream in, char ch) throws IOException {
		
		int b;

		do {
			b = in.read();
		} while (b>=0 && b!=ch && Character.isWhitespace(ch));

		return (b==ch?Character.MIN_VALUE:(char)b);

	}	
	
	/* (non-Javadoc)
	 * @see webcrawler.HTMLReader#readString(java.io.InputStream, char, char)
	 */
	//@Override
	public String readString(InputStream in, char ch1, char ch2) throws IOException {
		
		int b;
        StringBuilder sb = new StringBuilder();

        do {
			b = in.read();
			sb.append((char)b);
		} while (b>=0 && b!=ch1 && b!=ch2);

		return ( (b==ch1 || b==-1) ? sb.toString() : null);
		
	}

	
}
