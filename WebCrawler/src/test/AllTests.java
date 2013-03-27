package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseUtilTest.class, FinalurllistTest.class,
		HTMLReaderTest.class, LinkExtractorTest.class,
		TemporaryurllistTest.class, URLFilterExampleImplTest.class,
		URLFilterNullImplTest.class, URLListArrayListImplTest.class,
		URLListDBFinalImplTest.class, URLListDBTempImplTest.class,
		URLListElementTest.class, WebCrawlerConfigurationFactoryTest.class,
		WebCrawlerTest.class })
public class AllTests {
	
}
