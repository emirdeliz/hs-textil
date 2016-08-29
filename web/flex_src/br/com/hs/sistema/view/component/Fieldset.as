package br.com.hs.sistema.view.component
{
	
	import mx.containers.Panel;
	import mx.core.UIComponent;
	import mx.core.UITextField;

	public class Fieldset extends Panel {
		      
        private var pTitleBar:UIComponent;
 		private var t:UITextField = new UITextField();
 		public var fieldsetLabel:String;
				
		public function Fieldset() {
			
		}
					
		override protected function createChildren():void {
 		   super.createChildren();  
 		   
 		   this.pTitleBar = super.titleBar;
 		    
 		   t.text = fieldsetLabel;	   
     	   t.width = t.textWidth+20;
           t.background = true;
           t.x = 12;
           t.height = 22;
           t.backgroundColor = 0xD4D0C8;       
           this.pTitleBar.addChild(t);          

		}
	
	}
}

