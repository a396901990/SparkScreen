package com.dean.sparkscreen;

import java.util.Date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SparkView extends SurfaceView implements SurfaceHolder.Callback,
		Runnable {

	private SurfaceHolder mHolder;
	private Canvas mCanvas;
	private SparkPaint mSparkPaint;
	double X = 0;
	double Y = 0;

	public SparkView(Context context) {
		super(context);
		mHolder = this.getHolder();
		mHolder.addCallback(this);
		mSparkPaint = new SparkPaint();
	}

	@Override
	public void run() {
		boolean isEnd = false;
		boolean isPlus = true;
		int alpha = 0;
		Date d = null;
		while (true) {

				d = new Date();

				if (alpha >= 200) {
					isPlus = false;
				}else if (alpha < 0){
					isPlus = true;
				}

				if (isPlus) {
					alpha += 10;
					X += 30;
					Y += 30;
				} else {
					alpha -= 10;
					X -= 30;
					Y -= 30;
				}

				if (alpha > 0) {
					Canvas canvas = mHolder.lockCanvas();// 获取画布

					Paint p = new Paint();
					canvas.drawColor(Color.BLACK);
					 //清屏
//					 p.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
//					 canvas.drawPaint(p);
//					 p.setXfermode(new PorterDuffXfermode(Mode.SRC));
					mSparkPaint.drawSpark(canvas, (float) X, (float) Y, alpha);
					try {
						Thread.sleep(Math.max(0,
								33 - (new Date().getTime() - d.getTime())));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mHolder.unlockCanvasAndPost(canvas);// 解锁画布，提交画好的图像
				}
				if (alpha < 0) {
					// isEnd = true;
				}

		}
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
				X = event.getX();
				Y = event.getY();
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
			mSparkPaint
					.drawSpark(mCanvas, (float) (x += 10), (float) (y += 10));
			mHolder.unlockCanvasAndPost(mCanvas);
		}
	}

	public void drawClear() {
		mCanvas = mHolder.lockCanvas();
		if (mCanvas != null) {
			mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
			mHolder.unlockCanvasAndPost(mCanvas);
		}
	}

	// Surface的大小发生改变时调用
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		drawBackgound();
	}

	// Surface创建时激发，一般在这里调用画面的线程
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		new Thread(this).start();
	}

	// 销毁时激发，一般在这里将画面的线程停止、释放。
	@Override
	public void surfaceDestroyed(SurfaceHolder argholder0) {
		// TODO Auto-generated method stub

	}
}
