package webcrawler;

import java.util.Iterator;

public interface URLList {

	public void add(int priority, String url);

	public void add(URLListElement e);

	public String toString();
	
	public URLListElement get(int idx);

	public int size();
	
	public Iterator<URLListElement> iterator();
	
}

