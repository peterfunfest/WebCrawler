package webcrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of URLList which manages the list of URLs during the crawl in
 * a non-persistent manner
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public class URLListArrayListImpl implements URLList {
	
	private int idx;
	private int size;
	private List<URLListElement> urls;
	private URLFilter uRLFilter;
	
	/**
	 * Constructor - Initialises list
	 */
	public URLListArrayListImpl() {
		this.idx = -1;
		this.size = 0;
		urls = new ArrayList<URLListElement>();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#add(int, java.lang.String)
	 */
	@Override
	public boolean add(int priority, String url) {
		return this.add(new URLListElement(priority, url));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#add(webcrawler.URLListElement)
	 */
	@Override
	public boolean add(URLListElement e) {
		urls.add(e);
		this.size++;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#get(int)
	 */
	@Override
	public URLListElement get(int idx) {
		return this.urls.get(idx);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#size()
	 */
	@Override
	public int size() {
		return this.urls.size();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#getuRLFilter()
	 */
	@Override
	public URLFilter getuRLFilter() {
		return uRLFilter;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#setuRLFilter(webcrawler.URLFilter)
	 */
	@Override
	public void setuRLFilter(URLFilter uRLFilter) {
		this.uRLFilter = uRLFilter;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#iterator()
	 */
	@Override
	public Iterator<URLListElement> iterator() {
		
		return new Iterator<URLListElement>() {
			
			@Override
			public boolean hasNext() {
				return (idx + 1 < size);
			}
			
			@Override
			public URLListElement next() {
				idx++;
				return get(idx);
			}
			
			@Override
			public void remove() {
				throw new java.lang.IllegalAccessError("Method not implemented");
			}
		};
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return urls.toString();
	}
	
}