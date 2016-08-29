package br.com.hs.sistema.utils;

import br.com.hs.sistema.controller.logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;

public class TwitterUtils {
	@SuppressWarnings("deprecation")
	public static String tweet(String msg) throws TwitterException{
		logger.info("Preparing new twitt");
		logger.info("Hello word this is my twitt: " + msg);
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("2ja1VfEzxOCdPe9OZcpC0A", "DF2LNBtzsx0zOgNyY7raYpuYLd73xdpTGYAumFVsn0");
		AccessToken accessToken = new AccessToken ("81637498-9lDzyhgUbjyTQQXXMcLD2TJcq22gXW57YVPxpEuA","V7CMNJs84858UzyeDhyFNBzMrwC3FMK6bUe7yrMaUg");
		//twitterToken, twitterTokenSecret
		twitter.setOAuthAccessToken (accessToken);
		Status status = twitter.updateStatus(msg);
		return status.getText();
	}
}
