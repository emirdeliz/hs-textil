package br.com.clinic.view.utils
{
	import br.com.clinic.model.entity.People;
	
	import flash.events.MouseEvent;
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	
	import mx.controls.Alert;
	
	public class SessionManager
	{
		private static var currentUser:People;
		private static var timer:Timer;
		private static var TIME_OUT:int = 0;
		private static var DELAY:int = 1; 
		private static var logout:Function;
		
		public static function init(user:People, func:Function, timeOut:int):void{
			TIME_OUT = Utils.parseSecMilSec(timeOut);
			currentUser = user;
			logout = func;
			timer = new Timer(TIME_OUT, DELAY);
			timer.addEventListener(TimerEvent.TIMER_COMPLETE, onTimeOut);	
			timer.start();
		}
		
		public static function onTimeOut(event:TimerEvent):void{		
			Alert.show("Sessão expirada.");
			timer.reset();
			timer.stop();	
			logout();			 
		}
		
		public static function refresh(event:MouseEvent):void{
			timer.reset();
		}	
		
		public static function getCurrentUser():People{
			return currentUser;
		}		
	}
}