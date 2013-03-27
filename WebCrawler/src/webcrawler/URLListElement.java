package webcrawler;

/**
 * Model for single URL held within a list
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public class URLListElement {
	
	private int priority;
	private String url;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof URLListElement)) {
			throw new IllegalArgumentException();
		}
		return (url.equals(((URLListElement) obj).getUrl()) && priority == (((URLListElement)obj).getPriority()));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return url.hashCode();
		
	}
	
	/**
	 * Constructor - Sets priority and url of the element
	 * 
	 * @param priority
	 *            Priority of the element
	 * @param url
	 *            URL of the element
	 */
	public URLListElement(int priority, String url) {
		this.priority = priority;
		this.url = url;
	}
	
	/**
	 * Get the priority of the element
	 * 
	 * @return Priority of the element
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * Set the priority of the element
	 * 
	 * @param priority
	 *            Priority of the element
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * Get the URL of the element
	 * 
	 * @return URL of the element
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Set the URL of the element
	 * 
	 * @param url
	 *            The URL of the element
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Priority:" + priority + ", url:" + url;
	}
	
}
