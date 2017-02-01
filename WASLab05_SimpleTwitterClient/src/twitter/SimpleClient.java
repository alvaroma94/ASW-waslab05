package twitter;

import java.util.Date;
import twitter4j.User;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		
		final Twitter twitter = new TwitterFactory().getInstance();
		
		Date now = new Date();
		/*User usuario = twitter.showUser(Long.parseLong("2821141762"));
		long id = usuario.getStatus().getId();
		String texto = usuario.getStatus().getText();
		System.out.println(texto);
		twitter.retweetStatus(id);*/
		
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		
		StatusListener listener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void onStatus(Status arg0) {
				// TODO Auto-generated method stub
		        User user = arg0.getUser();
		        System.out.println(user.getName() + " (@"+ user.getScreenName() + "): "+ arg0.getText());
			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}   
		};

	    FilterQuery filterquery = new FilterQuery();
	    String key[] = { "#barcelona" };
	    filterquery.track(key);
	    twitterStream.addListener(listener);
	    twitterStream.filter(filterquery);
		
		//String latestStatus = "I want to increase the Klout score of @cfarre [task #4 completed "+now+"]";
		//Status status = twitter.updateStatus(latestStatus);
		//System.out.println("Successfully updated the status to: " + status.getText());       
	}
}
