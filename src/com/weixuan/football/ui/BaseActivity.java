/*
 * Created by Storm Zhang, Feb 11, 2014.
 */

package com.weixuan.football.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity {
    protected FootballApplication application;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onStop() {
		super.onStop();
	}


    protected void initView(){

    }

}
