package webcrawler;

public class URLListElement {

	private int     priority;
	private String  url;
	
	public URLListElement(int priority, String url) {
		this.priority = priority;
		this.url = url;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		return "Priority:" + priority + ", url:"+url;
	}
	
}
