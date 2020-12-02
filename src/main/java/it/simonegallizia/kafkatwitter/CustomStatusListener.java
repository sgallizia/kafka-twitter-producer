package it.simonegallizia.kafkatwitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import it.simonegallizia.kafkatwitter.models.Tweet;
import lombok.extern.log4j.Log4j2;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Log4j2
@Component
class CustomStatusListener implements StatusListener {
	@Autowired
	KafkaTemplate<String, Tweet> kafkaTemplate;
	
	@Override
	public void onException(Exception ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatus(Status status) {
		System.out.print("Tweet");
		Tweet tweet = new Tweet();
		tweet.setText(status.getText());
		tweet.setAuthor(status.getUser().getName());
		log.info("publishing tweet on kakfa " + tweet);
		kafkaTemplate.send("b2b-events", tweet);
		
		
		
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning warning) {
		// TODO Auto-generated method stub
		
	}
	
}