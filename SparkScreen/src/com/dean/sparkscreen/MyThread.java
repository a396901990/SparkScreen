package com.dean.sparkscreen;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

	private SurfaceHolder holder;
	public boolean isRun;

	public MyThread(SurfaceHolder holder) {
		this.holder = holder;
		isRun = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}
