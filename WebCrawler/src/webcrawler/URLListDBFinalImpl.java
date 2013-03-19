package webcrawler;

import java.util.Iterator;

import model.Finalurllist;
import db.DatabaseUtil;

public class URLListDBFinalImpl implements URLList {

    private int saveIdx=1;
    private int readIdx=1;
	private DatabaseUtil db;
	private URLFilter    uRLFilter;

	public URLListDBFinalImpl() {
		this.db = DatabaseUtil.getInstance();
		db.deleteAllFromFinalTable();
	}

	@Override
	public boolean add(int priority, String url) {
		return this.add(new URLListElement(priority, url));
	}

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

	@Override
	public URLListElement get(int idx) {
		Finalurllist t = db.getFinalURLListById(idx);
		return new URLListElement(t.getPriority(), t.getUrl());
	}

	@Override
	public int size() {
		return saveIdx-1;
	}

	@Override
	public URLFilter getuRLFilter() {
		return uRLFilter;
	}

	@Override
	public void setuRLFilter(URLFilter uRLFilter) {
		this.uRLFilter = uRLFilter;
	}

	@Override
	public Iterator<URLListElement> iterator() {

	    readIdx=1;

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
			}};

	}

	@Override
	public String toString() {
		return this.toString();
	}

}
