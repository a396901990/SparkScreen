package com.dean.sparkscreen;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SparkPaint {

	public Paint sparkPaint;

	public SparkPaint() {

		setSparkPaint();
	}

	private void setSparkPaint() {
		sparkPaint = new Paint();
		 // ´ò¿ª¿¹¾â³İ  
		this.sparkPaint.setAntiAlias(true);
		this.sparkPaint.setDither(true);
	    /* 
	     * ÉèÖÃ»­±ÊÑùÊ½ÎªÌî³ä
	     * Paint.Style.STROKE£ºÃè±ß 
	     * Paint.Style.FILL_AND_STROKE£ºÃè±ß²¢Ìî³ä 
	     * Paint.Style.FILL£ºÌî³ä 
	     */  
		this.sparkPaint.setStyle(Paint.Style.FILL);
		this.sparkPaint.setColor(Color.YELLOW);
		this.sparkPaint.setMaskFilter(new BlurMaskFilter(15.0F,
				BlurMaskFilter.Blur.NORMAL));
	}

	public void drawSpark(Canvas canvas, float x, float y) {
		canvas.drawCircle(x, y, 30, sparkPaint);
	}
	
	public void drawSpark(Canvas canvas, float x, float y, int alpha) {
		sparkPaint.setAlpha(alpha);
		canvas.drawCircle(x, y, 30, sparkPaint);
	}
	
}
