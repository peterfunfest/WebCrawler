package webcrawler;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Factory class in order to manage injection of the various classes used as
 * part of the crawler
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 */

public class WebCrawlerConfigurationFactory {
	
	private static WebCrawlerConfigurationFactory instance = null;
	private Properties props = null;
	
	private String htmlReaderClass;
	
	private String tempURLListClass;
	private String finalURLListClass;
	
	private String tempURLFilterClass;
	private String finalURLFilterClass;
	
	private int maximumDepth;
	private int maximumDistinctURLs;
	
	private String startURL;
	
	/**
	 * Constructor - Get the various properties from a configuration file in
	 * order to provide dependency injection capabilities
	 */
	private WebCrawlerConfigurationFactory() {
		
		props = new Properties();
		try {
			props.load(new FileInputStream("webcrawler.properties"));
			htmlReaderClass = props.getProperty("htmlReader");
			tempURLListClass = props.getProperty("tempURLList");
			tempURLFilterClass = props.getProperty("tempURLFilter");
			finalURLListClass = props.getProperty("finalURLList");
			finalURLFilterClass = props.getProperty("finalURLFilter");
			maximumDepth = Integer
					.valueOf(props.getProperty("maximumDepth") == null ? "0"
							: props.getProperty("maximumDepth"));
			maximumDistinctURLs = Integer.valueOf(props
					.getProperty("maximumDistinctURLs") == null ? "0" : props
					.getProperty("maximumDistinctURLs"));
			startURL = props.getProperty("startURL");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	static {
		instance = new WebCrawlerConfigurationFactory();
	}
	
	/**
	 * Get the current instance
	 * 
	 * @return The current instance
	 */
	public static WebCrawlerConfigurationFactory getInstance() {
		return instance;
	}
	
	/**
	 * Get an instance of HTMLReader
	 * 
	 * @return Instance of HTMLReader
	 */
	public HTMLReader getHTMLReader() {
		HTMLReader htmlReader = null;
		try {
			htmlReader = (HTMLReader) Class.forName(htmlReaderClass)
					.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return htmlReader;
	}
	
	/**
	 * Get an instance of TempURLList
	 * 
	 * @return Instance of TempURLList
	 */
	public URLList getTempURLList() {
		URLList urlList = null;
		try {
			urlList = (URLList) Class.forName(tempURLListClass).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlList;
	}
	
	/**
	 * Get an instance of FinalURLList
	 * 
	 * @return Instance of FinalURLList
	 */
	public URLList getFinalURLList() {
		URLList urlList = null;
		try {
			urlList = (URLList) Class.forName(finalURLListClass).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlList;
	}
	
	/**
	 * Get instance of TempURLFilter to allow for search functionality
	 * 
	 * @return Instance of TempURLFilter
	 */
	public URLFilter getTempURLFilter() {
		URLFilter urlFilter = null;
		try {
			urlFilter = (URLFilter) Class.forName(tempURLFilterClass)
					.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlFilter;
	}
	
	/**
	 * Get instance of FinalURLFilter to allow for search functionality
	 * 
	 * @return Instance of FinalURLFilter
	 */
	public URLFilter getFinalURLFilter() {
		URLFilter urlFilter = null;
		try {
			urlFilter = (URLFilter) Class.forName(finalURLFilterClass)
					.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return urlFilter;
	}
	
	/**
	 * Get the maximum depth for the crawler
	 * 
	 * @return The maximum depth for the crawler
	 */
	public int getMaximumDepth() {
		return this.maximumDepth;
	}
	
	/**
	 * Get the maximum number of distinct URLs
	 * 
	 * @return The maximum number of distinct URLs
	 */
	public int getMaximumDistinctURLs() {
		return this.maximumDistinctURLs;
	}
	
	/**
	 * Get the start URL for the crawl
	 * 
	 * @return The start URL for the crawl
	 */
	public String getStartURL() {
		return this.startURL;
	}
	
}
