package webcrawler;

import java.io.IOException;
import java.io.InputStream;

public interface HTMLReader {

	public abstract boolean readUntil(InputStream in, char ch1, char ch2)
			throws IOException;

	public abstract int skipSpace(InputStream in, char ch) throws IOException;

	public abstract String readString(InputStream in, char ch1, char ch2)
			throws IOException;

}