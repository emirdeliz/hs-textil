package br.com.hs.sistema.view.component
{
	import mx.containers.FormItem;
	
	[Style(name="percentWidth", type="Number", format="Length", inherit="no")]
	[Style(name="percentHeight", type="Number", format="Length", inherit="no")]	
	public class FormItemCustom extends FormItem
	{
		public function FormItemCustom()
		{
			super();
		}		
		override public function get percentWidth():Number {
			return getStyle("percentWidth");
		}					
	}
}