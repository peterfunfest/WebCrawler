package webcrawler;

import java.util.Iterator;

import model.Finalurllist;
import db.DatabaseUtil;

/**
 * Implementation of URLList which manages the list of final URLs in a
 * persistent manner
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */
public class URLListDBFinalImpl implements URLList {
	
	private int saveIdx = 1;
	private int readIdx = 1;
	private DatabaseUtil db;
	private URLFilter uRLFilter;
	
	/**
	 * Constructor - Gets instance of the database and deletes all previous
	 * records
	 */
	public URLListDBFinalImpl() {
		this.db = DatabaseUtil.getInstance();
		db.deleteAllFromFinalTable();
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
		if (uRLFilter.search(e.getUrl())) {
			db.insertRecordFinalTable(saveIdx, e.getUrl(), e.getPriority());
			saveIdx++;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#get(int)
	 */
	@Override
	public URLListElement get(int idx) {
		Finalurllist t = db.getFinalURLListById(idx);
		return new URLListElement(t.getPriority(), t.getUrl());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see webcrawler.URLList#size()
	 */
	@Override
	public int size() {
		return saveIdx - 1;
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
		
		readIdx = 1;
		
		return new Iterator<URLListElement>() {
			
			@Override
			public boolean hasNext() {
				return (readIdx < saveIdx);
			}
			
			@Override
			public URLListElement next() {
				return get(readIdx++);
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
		return this.toString();
	}
	
}
