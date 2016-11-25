package com.example.viewonclickdemo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	protected static final String tag = "MainActivity";
	private Button button;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);
		imageView = (ImageView) findViewById(R.id.imageView);
		
		//imageView默认没有点击事件的
		imageView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.i(tag, "imageView MotionEvent =" +event.getAction());
				//0  按下
				//1 抬起
				//2 移动
				
				//返回false，只会去响应按下的事件,一次，dispatchTouchEvent返回false，没有去消费所有事件
				//返回true，回去响应按下抬起事件，两次,如果dispatchTouchEvent返回true，响应(消费)所有的事件
				return false;
			}
		});
		
		//给imageView添加一个点击事件,事件处理规则跟button就没有差异了，不管返回true还是false都会响应所有事件
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		//因为有点击事件，返回false时候会响应两次
		button.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.i(tag, "button MotionEvent =" +event.getAction());
				//0  按下
				//1 抬起
				//2 移动
				//返回false，响应按下抬起，两次，dispatchTouchEvent返回true，响应(消费)所有的事件
				//返回true，响应按下抬起，两次，dispatchTouchEvent返回true，响应(消费)所有的事件
				return false;
			}
		});
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//onTouch方法中返回true，点击事件不会被触发
				//onTouch方法中返回false，点击事件会被触发
				Log.i(tag, "button onClick........");
			}
		});
	}
	
	//disptachTouchEvent()
}
