package webcrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class URLListArrayListImpl implements URLList {

    private int idx;
    private int size;
	private List<URLListElement> urls;
	private URLFilter            uRLFilter;

	public URLListArrayListImpl() {
		this.idx=-1;
        this.size=0;
		urls = new ArrayList<URLListElement>();
	}

	@Override
	public void add(int priority, String url) {
		this.add(new URLListElement(priority, url));
	}

	@Override
	public void add(URLListElement e) {
		urls.add(e);
		this.size++;
	}

	@Override
	public URLListElement get(int idx) {
		return this.urls.get(idx);
	}

	@Override
	public int size() {
		return this.urls.size();
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

		return new Iterator<URLListElement>() {

			@Override
			public boolean hasNext() {
				return (idx+1 < size);
			}

			@Override
			public URLListElement next() {
				idx++;
				return get(idx);
			}

			@Override
			public void remove() {
				throw new java.lang.IllegalAccessError("Method not implemented");
			}};

	}

	@Override
	public String toString() {
		return urls.toString();
	}

}