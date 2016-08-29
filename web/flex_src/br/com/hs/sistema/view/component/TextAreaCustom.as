package br.com.hs.sistema.view.component
{
	import mx.controls.TextArea;
	
	[Style(name="height", type="Number", format="Length", inherit="no")]
	[Style(name="width" , type="Number", format="Length", inherit="no")]
	public class TextAreaCustom extends TextArea
	{
		public function TextAreaCustom()
		{
			super();		
		}		
		override public function get width():Number {
			return getStyle("width");
		}
		override public function get height():Number {
			return getStyle("height");
		}		
		override public function get wordWrap():Boolean {
			return true;
		}
		
	}
}