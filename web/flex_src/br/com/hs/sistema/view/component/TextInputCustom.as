package br.com.hs.sistema.view.component
{
	import mx.controls.TextInput;
	
	[Style(name="height", type="Number", format="Length", inherit="no")]
	[Style(name="width" , type="Number", format="Length", inherit="no")]
	public class TextInputCustom extends TextInput
	{
		public function TextInputCustom()
		{
			super();
		}		
		override public function get width():Number {
			return getStyle("width");
		}
		override public function get height():Number {
			return getStyle("height");
		}		
	}
}