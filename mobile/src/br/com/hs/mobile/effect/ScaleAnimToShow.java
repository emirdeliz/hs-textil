package br.com.hs.mobile.effect;

import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class ScaleAnimToShow extends ScaleAnimation {

	private View mView;

	private LayoutParams mLayoutParams;

	private int mMarginBottomFromY, mMarginBottomToY;	

	public ScaleAnimToShow(float toX, float fromX, float toY, float fromY,
			int duration, View view, boolean vanishAfter) {
		super(fromX, toX, fromY, toY);
		
		this.setDuration(duration);
		this.mView = view;		
		this.mLayoutParams = (LayoutParams) view.getLayoutParams();
		this.mView.setVisibility(View.VISIBLE);
		int height = mView.getHeight();
		
		this.mMarginBottomFromY = 0;
		this.mMarginBottomToY = height;
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		super.applyTransformation(interpolatedTime, t);
		if (interpolatedTime < 1.0f) {
			int newMarginBottom = (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime)
					- mMarginBottomToY;
			this.mLayoutParams.setMargins(mLayoutParams.leftMargin,
					mLayoutParams.topMargin, mLayoutParams.rightMargin,
					newMarginBottom);
			this.mView.getParent().requestLayout();			
		}
	}

}
