package com.dean.sparkscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SparkView extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder mHolder;
	private Canvas mCanvas;
	private Paint mPaint;
	
	public SparkView(Context context) {
		super(context);
		initPaint();
		mHolder = this.getHolder();
		mHolder.addCallback(this);
	}
	
	/** 
	 * 初始化画笔 
	 */  
	private void initPaint() {  
	    // 实例化画笔并打开抗锯齿  
	    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);  
	  
	    /* 
	     * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了 
	     *  
	     * 画笔样式分三种： 
	     * 1.Paint.Style.STROKE：描边 
	     * 2.Paint.Style.FILL_AND_STROKE：描边并填充 
	     * 3.Paint.Style.FILL：填充 
	     */  
	    mPaint.setStyle(Paint.Style.STROKE);  
	  
	    // 设置画笔颜色为浅灰色  
	    mPaint.setColor(Color.LTGRAY);  
	  
	    /* 
	     * 设置描边的粗细，单位：像素px 
	     * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素 
	     */  
	    mPaint.setStrokeWidth(10);  
	} 

	// Surface的大小发生改变时调用
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		drawBackgound();
	}

	private void drawBackgound() {
		mCanvas = mHolder.lockCanvas();
		mCanvas.drawColor(Color.BLACK);
		mHolder.unlockCanvasAndPost(mCanvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getPointerCount()) {
		case 1:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				drawSparkPonit(event.getX(), event.getY());
				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			default:
				break;
			}
			break;
		}

		return super.onTouchEvent(event);
	}

	private void drawSparkPonit(double x, double y) {
		mCanvas = mHolder.lockCanvas();
		mCanvas.drawCircle((int)x, (int)y, 50, mPaint);
		mHolder.unlockCanvasAndPost(mCanvas);
	}

	// Surface创建时激发，一般在这里调用画面的线程
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	// 销毁时激发，一般在这里将画面的线程停止、释放。
	@Override
	public void surfaceDestroyed(SurfaceHolder argholder0) {
		// TODO Auto-generated method stub

	}

}
