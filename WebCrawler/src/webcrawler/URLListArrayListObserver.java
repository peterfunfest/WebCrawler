package webcrawler;

import java.util.Observable;
import java.util.Observer;

public class URLListArrayListObserver implements Observer {

	private String observerType;
	
	public URLListArrayListObserver(String observerType)  {
		this.observerType = observerType; 
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		if (!(arg0 instanceof webcrawler.URLListArrayListImpl)) {
		   throw new java.lang.IllegalArgumentException();
		}

		System.out.println(observerType + " - " + arg1.toString());

	}

}
