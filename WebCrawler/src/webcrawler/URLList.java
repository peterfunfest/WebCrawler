package webcrawler;

import java.util.Iterator;

public interface URLList {

	public boolean add(int priority, String url);

	public boolean add(URLListElement e);

	public String toString();
	
	public URLListElement get(int idx);

	public int size();
	
	public URLFilter getuRLFilter();

	public void setuRLFilter(URLFilter uRLFilter);
	
	public Iterator<URLListElement> iterator();
	
}

