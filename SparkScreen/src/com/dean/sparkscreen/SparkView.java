package com.dean.sparkscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SparkView extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder mHolder;
	private Canvas mCanvas;
	private SparkPaint mSparkPaint;
	
	public SparkView(Context context) {
		super(context);
		mHolder = this.getHolder();
		mHolder.addCallback(this);
		mSparkPaint = new SparkPaint();
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
				drawClear();
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
		if (mCanvas != null) {
			mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
			mSparkPaint.drawSpark(mCanvas, (float)x, (float)y);
			mHolder.unlockCanvasAndPost(mCanvas);
		}
	}
	
	public void drawClear() {
		mCanvas = mHolder.lockCanvas();
		if (mCanvas != null) {
			mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
			// mCanvas.drawColor(Color.alpha(0));
			mHolder.unlockCanvasAndPost(mCanvas);
		}
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
