package webcrawler;

public class URLFilterNullImpl implements URLFilter {

	@Override
	public boolean search(String url) {
		return true;
	}

}
