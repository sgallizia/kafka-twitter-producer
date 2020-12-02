package it.simonegallizia.kafkatwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Component
public class TweetFetcher implements CommandLineRunner {
	
	@Autowired
	CustomStatusListener listener;
	

	public void run(String... args) throws Exception {
	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(listener);
	    twitterStream.sample();
		
		
	}


}
