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
		
		//imageViewĬ��û�е���¼���
		imageView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.i(tag, "imageView MotionEvent =" +event.getAction());
				//0  ����
				//1 ̧��
				//2 �ƶ�
				
				//����false��ֻ��ȥ��Ӧ���µ��¼�,һ�Σ�dispatchTouchEvent����false��û��ȥ���������¼�
				//����true����ȥ��Ӧ����̧���¼�������,���dispatchTouchEvent����true����Ӧ(����)���е��¼�
				return false;
			}
		});
		
		//��imageView���һ������¼�,�¼���������button��û�в����ˣ����ܷ���true����false������Ӧ�����¼�
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		//��Ϊ�е���¼�������falseʱ�����Ӧ����
		button.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.i(tag, "button MotionEvent =" +event.getAction());
				//0  ����
				//1 ̧��
				//2 �ƶ�
				//����false����Ӧ����̧�����Σ�dispatchTouchEvent����true����Ӧ(����)���е��¼�
				//����true����Ӧ����̧�����Σ�dispatchTouchEvent����true����Ӧ(����)���е��¼�
				return false;
			}
		});
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//onTouch�����з���true������¼����ᱻ����
				//onTouch�����з���false������¼��ᱻ����
				Log.i(tag, "button onClick........");
			}
		});
	}
	
	//disptachTouchEvent()
}
