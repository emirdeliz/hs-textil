package br.com.hs.view.component.espelho
{
	/********************************************
 title   : Reflection Manager
 version : 0.9
 author  : Wietse Veenstra
 website : http://www.wietseveenstra.nl
 date    : 2007-04-25
********************************************/
    import mx.core.UIComponent;
    import mx.events.FlexEvent;
    import mx.events.MoveEvent;
    import mx.events.ResizeEvent;
    
    import flash.display.Bitmap;
    import flash.display.BitmapData;
    import flash.display.BlendMode;
    import flash.display.GradientType;
    import flash.display.Graphics;
    import flash.display.Shape;
    import flash.geom.Point;
    import flash.geom.Matrix;
    import flash.geom.Rectangle;
        
    public class ReflectionManager extends UIComponent {
        private var _bitmap:Bitmap = new Bitmap(new BitmapData(1, 1, true, 0));
        private var _targetBMData:BitmapData;
        private var _alphaGrBMData:BitmapData;
        private var _combinedBMData:BitmapData;
        private var _alphaGradient:Matrix;
        private var _fadeFrom:Number = 0.3;
        private var _fadeTo:Number = 0;
        private var _matrix:Matrix;
        private var _point:Point;
        private var _rectangle:Rectangle;
        private var _shape:Shape;
        private var _target:UIComponent;
        
        public function ReflectionManager():void {
            this.addChild(this._bitmap);
        }
        
        public function get fadeFrom():Number {
            return this._fadeFrom;
        }
        
        public function set fadeFrom(value:Number):void {
            this._fadeFrom = value;
            this.invalidateDisplayList();
        }
        
        public function get fadeTo():Number {
            return this._fadeFrom;
        }
        
        public function set fadeTo(value:Number):void {
            this._fadeTo = value;
            this.invalidateDisplayList();
        }
        
        public function set target(value:UIComponent):void {
            this._target = value;
            this.width = this._target.width;
            this._target.addEventListener(FlexEvent.UPDATE_COMPLETE, targetUpdateHandler, true);
            this._target.addEventListener(MoveEvent.MOVE, targetMoveHandler, true);
            this._target.addEventListener(ResizeEvent.RESIZE, targetResizeHandler, true);
        }
        
        private function targetUpdateHandler(event:FlexEvent):void {
            this.invalidateDisplayList();
        }
        
        private function targetMoveHandler(event:MoveEvent):void {
            this._bitmap.x = this._target.x;
            this._bitmap.y = this._target.y + this._target.height - 1; 
        }
        
        private function targetResizeHandler(event:ResizeEvent):void {
            this._bitmap.width = _target.width;
            this.invalidateDisplayList();
        }
        
        override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
            if (_target != null) {
                this.drawReflection(_target);
                
                this._bitmap.bitmapData.dispose();
                this._bitmap.bitmapData = this._combinedBMData;
                
                this._bitmap.x = _target.x;
                this._bitmap.y = _target.y + _target.height - 1;
            } else {
                this.clearBMData();
            }
        }
        
        private function drawReflection(target:UIComponent):void { 
            if (this.width > 0 && this.height > 0) {
                this._matrix = new Matrix(1, 0, 0, -1, 0, target.height);
                this._point = this._matrix.transformPoint(new Point(0, target.height));
                this._matrix.tx = this._point.x * -1;
                this._matrix.ty = (this._point.y - target.height) * -1;
                
                this._targetBMData = new BitmapData(this.width, this.height, true, 0);
                this._targetBMData.draw(target, this._matrix);
                
                if (this._alphaGrBMData == null) {
                    this._alphaGradient = new Matrix();
                    this._alphaGradient.createGradientBox(this.width, this.height, Math.PI / 2);
                
                    this._shape = new Shape();
                    this._shape.graphics.beginGradientFill(GradientType.LINEAR, new Array(0, 0), new Array(this._fadeFrom, this._fadeTo), new Array(0, 0xFF), this._alphaGradient);
                    this._shape.graphics.drawRect(0, 0, this.width, this.height);
                    this._shape.graphics.endFill();
                
                    this._alphaGrBMData = new BitmapData(this.width, this.height, true, 0);
                    this._alphaGrBMData.draw(this._shape, new Matrix());
                }
                    
                this._rectangle = new Rectangle(0, 0, this.width, this.height);
                
                this._combinedBMData = new BitmapData(this.width, this.height, true, 0);
                this._combinedBMData.copyPixels(this._targetBMData, this._rectangle, new Point(), this._alphaGrBMData);
            }
        }
        
        public function clearBMData():void {
            this._targetBMData = null;
            this._alphaGrBMData = null;
            this._combinedBMData = null;
        }
    }
}