package com.dean.sparkscreen;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SparkView extends SurfaceView implements SurfaceHolder.Callback {

	public SparkView(Context context) {
		super(context);
	}

	// Surface的大小发生改变时调用
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

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
