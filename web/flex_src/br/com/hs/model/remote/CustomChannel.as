package br.com.hs.model.remote
{
	import mx.messaging.Channel;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	
	public class CustomChannel
	{
		
		public static function getChannelSet():ChannelSet
		{

			var cs:ChannelSet = new ChannelSet();
			var customChannel:Channel = new AMFChannel("my-amf", "http://localhost:9191/HSSistema/messagebroker/amf");
			cs.addChannel(customChannel);
			cs.logout(null);
			return cs;
		
		}

	}
}