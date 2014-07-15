package com.cursoAndroid.practica5;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class TabViewActivity extends Activity implements OnTabChangeListener {
	TabHost mTab;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		addWidgets();
		addListeners();
	}

	private void addListeners() {
		mTab.setOnTabChangedListener(this);
	}


	private void addWidgets() {
		Resources res = getResources();
		mTab = (TabHost) findViewById(android.R.id.tabhost);
		mTab.setup();

		TabHost.TabSpec spec;

		spec = mTab.newTabSpec("mitab1");
		spec.setContent(R.id.activity_tab_tab1);
		spec.setIndicator("TAB 1",
				res.getDrawable(android.R.drawable.ic_btn_speak_now));
		mTab.addTab(spec);

		spec = mTab.newTabSpec("mitab2");
		spec.setContent(R.id.activity_tab_tab2);
		spec.setIndicator("TAB 1",
				res.getDrawable(android.R.drawable.ic_dialog_map));
		mTab.addTab(spec);

		mTab.setCurrentTab(0);
	}

	@Override
	public void onTabChanged(String tabId) {
		Toast.makeText(this, "Pulsada pestaña:" + tabId, Toast.LENGTH_LONG).show();
		
	}
  
  
}
