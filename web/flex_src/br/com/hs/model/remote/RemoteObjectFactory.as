package br.com.clinic.model.remote
{
	import mx.rpc.remoting.mxml.RemoteObject;

	public class RemoteObjectFactory
	{
		public static function getRemoteObject(destination:String):RemoteObject
		{
			var remoteObj:RemoteObject = new RemoteObject();
			remoteObj.destination = destination;
			return remoteObj;
		}
	}
}