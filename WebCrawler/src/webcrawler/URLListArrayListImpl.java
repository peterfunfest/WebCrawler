package webcrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class URLListArrayListImpl extends Observable implements URLList {

    private int idx;
    private int size;
	private List<URLListElement> urls;

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
		this.setChanged();
		this.notifyObservers(e);
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