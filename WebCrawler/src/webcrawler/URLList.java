package webcrawler;

import java.util.ArrayList;
import java.util.List;

public class URLList {

	private List<URLListElement> urls;
	private String baseReference;
	
	public String getBaseReference() {
		return baseReference;
	}

	public void setBaseReference(String baseReference) {
		this.baseReference = baseReference;
	}

	public URLList() {
		 urls = new ArrayList<URLListElement>();
	}

    public URLList add(int priority, String url)	{
    	return this.add(new URLListElement(priority, url));
    }

    public URLList add(URLListElement e)	{
    	urls.add(e);
    	return this;
    }

    public URLList remove(URLListElement e) {
    	urls.remove(urls.indexOf(e));
    	return this;
    }

}
