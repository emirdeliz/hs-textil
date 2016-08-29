package br.com.hs.sistema.view.utils
{
	import br.com.thinklab.util.control.DecimalInput;
	
	import flash.utils.ByteArray;
	
	import mx.controls.CheckBox;
	import mx.controls.ComboBox;
	import mx.controls.RadioButton;
	import mx.controls.TextArea;
	import mx.controls.TextInput;
	import mx.core.Container;
	import mx.formatters.DateFormatter;
	import mx.formatters.NumberBaseRoundType;
	import mx.formatters.NumberFormatter;
	
	public class Utils
	{		
		public static function formatDec(vl:String):String {
			var numberFormat:NumberFormatter = new NumberFormatter();
            numberFormat.decimalSeparatorFrom = ".";
            numberFormat.decimalSeparatorTo = ",";
            numberFormat.precision = 2;
            numberFormat.rounding = NumberBaseRoundType.NEAREST;
            numberFormat.thousandsSeparatorFrom = ",";
            numberFormat.thousandsSeparatorTo = ".";
            numberFormat.useThousandsSeparator = true;
            return numberFormat.format(vl);
		}
		
		 public static function parseDec(str:String):Number{
            var p:RegExp = /\./g;  
            str = str.replace(new RegExp(),"");
            p = /\,/;
            str = str.replace(p, ".");            
            return Number(str);
        }
        
        public static function formatDat(date:Date):String{
        	var dateFormat:DateFormatter = new DateFormatter();
        	dateFormat.formatString = "DD/MM/YYYY";
        	return dateFormat.format(date);
        }
        
        public static function formatHourMin(date:Date):String{
        	var dateFormat:DateFormatter = new DateFormatter();
        	dateFormat.formatString = "HH:MM";
        	var dt:String = (date != null?dateFormat.format(date):"");
        	return dt;
        }
        
        public static function formatStrHourMin(str:String):String{
        	if(str.length == 1 && str.charAt(0) == ":")
        		str = str.replace(':', '');
        	else if(str.length == 2)        		      		
        		str += (str.charAt(1) != ':'? ':': str.replace(':', ''));
        	else if(str.length == 4 && str.charAt(3) == ":")
        		str = str.replace(':', '');
        	else if(str.length == 5 && str.charAt(4) == ":")
        		str = str.replace(':', '');
        	return str;
        }
        
         public static function limpaContainer(container:Container):void{
        	for each(var obj:Object in container.getChildren()){
        		if(obj is Container){
        			limpaContainer(obj as Container)
        		}else{  
        			 switch (obj.className){
        				case "ComboBox":
        					var cbx:ComboBox = obj as ComboBox;
        					cbx.selectedIndex = 0;
        					break;
        				case "TextInput":
        				case "TextInputCustom":            					
        				case "TextArea":
        				case "TextAreaCustom":  
        				case "DateField":         					
        					obj.text = "";
        					break;        					
        				case "DecimalInput":
        					var dec:TextInput = obj as TextInput; 
        					dec.text = "0,00";
        					break;
        				case "CheckBox":
        					var ckb:CheckBox = obj as CheckBox;
        					ckb.selected = false;
        				default:
        					break; 
        			}
        		}        			
        	}
        }
        
        public static function limpaCampos(campos:Array):void{        	
			for each(var obj:Object in campos){
				switch (obj.className){
						case "ComboBox":
							var cbx:ComboBox = obj as ComboBox;
							cbx.selectedIndex = 0;
							break;
						case "TextInput":
						case "TextInputCustom":    
							var txt:TextInput = obj as TextInput; 
							txt.text = "";
							break;
						case "TextArea":
						case "TextAreaCustom":    
						case "DateField":							
							obj.text = "";
							break;        					
						case "DecimalInput":
							var dec:TextInput = obj as TextInput; 
							dec.text = "0,00";
							break;
						case "CheckBox":
							var ckb:CheckBox = obj as CheckBox;
							ckb.selected = false;
						default:
							break;
				} 
			}        	
        }
        
        public static function desabilitar(container:Container, estado:Boolean):void{
        	for each(var obj:Object in container.getChildren()){
        		if(obj is Container){
        			desabilitar(obj as Container, estado);
        		}else{  
        			 switch (obj.className){
        				case "ComboBox":
        				case "TextInput":
        				case "TextInputCustom":
        				case "DateField":         					
        				case "TextArea":   
        				case "TextAreaCustom":     					      					
        				case "DecimalInput":        					
        				case "CheckBox":    
        				case "Datagrid":    					
        					obj.enabled = !estado;
        					break; 
        				case "Button":        					
        					obj.visible=!estado;
        					obj.includeInLayout=!estado;
        					break;        				
        				default:
        					break; 
        			}
        		}        			
        	}
        }
        
        public static function validaCampos(campos:Object):Boolean{				
			for each(var obj:Object in campos){				
				switch (obj.className){
    				case "ComboBox":
    					var cbx:ComboBox = obj as ComboBox;
    					if(cbx.selectedIndex ==0)
    						return false;
    					break;
    				case "TextInput":
    				case "TextInputCustom":  
    				case "DateField":     					
    					if(obj.text == "")
    						return false;
    					break;
    				case "TextArea":
    				case "TextAreaCustom":    
    					var txa:TextArea = obj as TextArea; 
    					if(txa.text == "")
    						return false;
    					break;        					
    				case "DecimalInput":
    					var dec:DecimalInput = obj as DecimalInput; 
    					if(dec.text == "" || Utils.parseDec(dec.decimalText) <=0)
    						return false;
    					break;
    				case "RadioButton":
    					var rdb:RadioButton = obj as RadioButton;
    					if(rdb.selectedField == "")
    						return false;    				
    				default:
    					break; 
    			}
			}
			return true;
		}
        
        public static function compareObject(obj1:Object,obj2:Object):Boolean{
		    var buffer1:ByteArray = new ByteArray();
		    buffer1.writeObject(obj1);
		    var buffer2:ByteArray = new ByteArray();
		    buffer2.writeObject(obj2);		 	
		    // compare the lengths
		    var size:uint = buffer1.length;
		    if (buffer1.length == buffer2.length) {
		        buffer1.position = 0;
		        buffer2.position = 0;
		 
		        // then the bits
		        while (buffer1.position < size) {
		            var v1:int = buffer1.readByte();
		            if (v1 != buffer2.readByte()) {
		                return false;
		            }
		        }    
		        return true;                        
		    }
		    return false;
		}
		
		public static function geraPass():String{
			var size:int=6;
			var specialChars:Boolean=true;
			var pass:String="";
			var chars:Array = new Array(
				"a","A","b","B","c","C","d","D","e","E","f","F",
				"g","G","h","H","i","I","j","J","k","K","l","L",
				"m","M","n","N","o","O","p","P","q","Q","r","R",
				"s","S","t","T","u","U","v","V","w","W","x","X",
				"y","Y","z","Z","1","2","3","4","5","6","7","8",
				"9","0","#","@","%","&","?",",",".","-","_","!",
				"+","$","€","="); 	
												
			for(var x:int=0; x<size; x++) {
				if(specialChars==true) 
					pass += chars[(Math.floor(Math.random() * (chars.length)))];
				else 
					pass += chars[(Math.floor(Math.random() * (chars.length-14)))];				
			}
			return pass;
		}    
		
		public static function parseSecMilSec(sec:Number):Number{
			var milSec:Number = sec * 60 * 1000; 
			return milSec;
		}    
	}
}