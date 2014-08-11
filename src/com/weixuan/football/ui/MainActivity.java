package com.weixuan.football.ui;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.weixuan.football.R;
import com.weixuan.football.data.ApiParams;
import com.weixuan.football.data.RequestManager;
import com.weixuan.football.fragment.LeftMenuFragment;
import com.weixuan.football.fragment.NewsFragment;
import com.weixuan.football.fragment.NewsMainFragment;
import com.weixuan.football.util.Dict;
import com.weixuan.football.util.UrlApi;
import com.weixuan.football.util.Util;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends SlidingFragmentActivity {
    public SlidingMenu mSlidingMenu;
    private Fragment newFragment;
    private LeftMenuFragment mFrag;
    private View vLeftMenu;
    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSlidingMenu(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        activity=this;
        requestTask();
    }

    private void initView(){
        vLeftMenu=findViewById(R.id.v_left_menu);
        vLeftMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidingMenu.showMenu();
            }
        });
    }
    private StringRequest request;
    private void requestTask(){
        Map<String,String> params=new HashMap<String, String>();
        params.put(Dict.CLIENT_ID,Dict.USER_NAME);
        params.put(Dict.SIGN, Dict.SIGN_CODE);
        params.put(Dict.REDIRECT_URI,Dict.URL);
        params.put(Dict.STATE,"1234");
        request=new StringRequest(Request.Method.POST, Util.jointUrl(UrlApi.AUTHORIZE),responseListener(),errorListener(),params);
        executeRequest(request);

    }

    private Response.Listener<String> responseListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        };
    }

    private void initSlidingMenu(Bundle savedInstanceState) {
        newFragment=new NewsMainFragment();
        setBehindContentView(R.layout.menu_frame);
                if (savedInstanceState == null) {
            mFrag = new LeftMenuFragment();
            this.getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, mFrag).commit();
        } else {
            mFrag =(LeftMenuFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }

        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.LEFT);//
        mSlidingMenu.setBehindWidthRes(R.dimen.slidingmenu_offset);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//
        mSlidingMenu.setFadeEnabled(true);
        mSlidingMenu.setShadowDrawable(R.drawable.shadow);
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        mSlidingMenu.setBehindScrollScale(0.001f);
        mSlidingMenu.setFadeDegree(0.2f);

    }
    /**
     * Fragment  跳转
     * @param fm
     * @param fragmentClass
     * @param args
     */
    public void turnToFragment(FragmentManager fm, Class<? extends Fragment> fragmentClass, Bundle args) {
        Fragment fragment = fm.findFragmentByTag(fragmentClass.getSimpleName());
        boolean isFragmentExist = true;
        if (fragment == null) {
            try {
                isFragmentExist = false;
                fragment = fragmentClass.newInstance();
                fragment.setArguments(new Bundle());
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(fragment.isAdded()){
            return;
        }
        if( args != null && !args.isEmpty() ) {
            fragment.getArguments().putAll(args);
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(0,0,android.R.anim.fade_in,android.R.anim.fade_out);
        if( isFragmentExist ) {
            ft.replace(R.id.content_frame, fragment);
        } else {
            ft.replace(R.id.content_frame, fragment,fragmentClass.getSimpleName());
        }
        ft.addToBackStack(fragmentClass.getSimpleName());
        ft.commitAllowingStateLoss();
        if (getSlidingMenu().isMenuShowing()){
            getSlidingMenu().showContent();
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        RequestManager.cancelAll(activity);
    }

    protected void executeRequest(Request<?> request) {
        RequestManager.addRequest(request, this);
    }

    protected Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("football","程序异常信息:"+error.getMessage());
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
    }

}
