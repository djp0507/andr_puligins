package com.plugin.commons.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.plugin.R;
import com.plugin.commons.ComApp;
import com.plugin.commons.view.ZqCircleView;


public class WebActivity   extends BaseActivity{
	private ZqCircleView mLJWebView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_govweb);
		
		mLJWebView = (ZqCircleView)this.findViewById(R.id.web);
		mLJWebView.setProgressStyle(ZqCircleView.Circle);
		mLJWebView.setBarHeight(8);
		mLJWebView.setClickable(true);
		mLJWebView.setUseWideViewPort(true);
		mLJWebView.setCacheMode(WebSettings.LOAD_NO_CACHE);		
		mLJWebView.setWebViewClient(new WebViewClient() {
			//重写此方法，浏览器内部跳转
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				System.out.println("跳的URL =" + url);
				view.loadUrl(url);
				return true;
			}
			
		});
		String url=ComApp.getInstance().appStyle.tv_setting_version_contact_website_tx;
		mLJWebView.loadUrl(url);
		initBottom();
	}
	
	private void initBottom()
	{
		this.findViewById(R.id.rl_bottom).setVisibility(View.VISIBLE);
		this.findViewById(R.id.btn_backweb).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mLJWebView.getmWebView().goBack();
			}
		});
		this.findViewById(R.id.btn_goweb).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mLJWebView.getmWebView().goForward();
			}
		});
		this.findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mLJWebView.getmWebView().reload();
			}
		});
	}
}
