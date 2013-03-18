package webcrawler;

import java.io.FileInputStream;
import java.util.Properties;


public class WebCrawlerConfigurationFactory {

	private static WebCrawlerConfigurationFactory instance = null;
	private Properties props = null;

    private String htmlReaderClass;
    
    private String tempURLListClass;
    private String finalURLListClass;

    private String tempURLFilterClass;
    private String finalURLFilterClass;

	private WebCrawlerConfigurationFactory() {
		props = new Properties();
		try {
			props.load(new FileInputStream("webcrawler.properties"));
			htmlReaderClass = props.getProperty("htmlReader");
			tempURLListClass = props.getProperty("tempURLList");
			tempURLFilterClass = props.getProperty("tempURLFilter");
			finalURLListClass = props.getProperty("finalURLList");
			finalURLFilterClass = props.getProperty("finalURLFilter");
        } catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static {
		instance = new WebCrawlerConfigurationFactory();
	}

	public static WebCrawlerConfigurationFactory getInstance() {
		return instance;
	}

	public HTMLReader getHTMLReader() {
        HTMLReader htmlReader=null;
		try {
			htmlReader = (HTMLReader)Class.forName(htmlReaderClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return htmlReader; 
	}

	public URLList getTempURLList() {
        URLList urlList=null;
		try {
			urlList = (URLList)Class.forName(tempURLListClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlList; 
	}

	public URLList getFinalURLList() {
        URLList urlList=null;
		try {
			urlList = (URLList)Class.forName(finalURLListClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlList; 
	}

	public URLFilter getTempURLFilter() {
        URLFilter urlFilter=null;
		try {
			urlFilter = (URLFilter)Class.forName(tempURLFilterClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlFilter; 
	}

	public URLFilter getFinalURLFilter() {
        URLFilter urlFilter=null;
		try {
			urlFilter = (URLFilter)Class.forName(finalURLFilterClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlFilter; 
	}

}
