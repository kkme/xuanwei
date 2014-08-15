package com.weixuan.football.ui;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExecutor;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;
import com.weixuan.football.R;
import com.weixuan.football.entity.Token;
import com.weixuan.football.fragment.LeftMenuFragment;
import com.weixuan.football.fragment.NewsMainFragment;
import com.weixuan.football.util.Dict;
import com.weixuan.football.util.UrlApi;
import com.weixuan.football.util.Util;

public class MainActivity extends SlidingFragmentActivity {

    private static final String TAG="tests";
    public SlidingMenu mSlidingMenu;
    private Fragment newFragment;
    private LeftMenuFragment mFrag;
    private View vLeftMenu;
    private Activity activity;
    private FootballApplication application;

    private LiteHttpClient client;
    private HttpAsyncExecutor asyncExecutor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSlidingMenu(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        application=(FootballApplication)getApplication();
        activity=this;
        client=LiteHttpClient.getInstance(activity);
        asyncExecutor=HttpAsyncExecutor.newInstance(client);
         new Thread(new Runnable() {
           @Override
           public void run() {
               requestUserTokenTask();
               requestRefreshTokenTask();
           }
       }).start();

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

    /***
     *授权验证
     */
    private void requestUserTokenTask(){
        Request req = new Request(Util.jointUrl(UrlApi.AUTHORIZE,UrlApi.WEB_MODEL_BASE)).setMethod(HttpMethod.Get).
                addUrlParam(Dict.CLIENT_ID, Dict.USER_NAME)
                .addUrlParam(Dict.SIGN, Dict.SIGN_CODE).
                addUrlParam(Dict.REDIRECT_URI, Dict.URL).
                 addUrlParam(Dict.STATE, "1234");
        Response res = client.execute(req);
       try {
           Token token=Util.convertToken(req.getUrl().toString());
            token.setClient_id(Dict.USER_NAME);
           application.setToken(token);
       }catch (Exception e){
       }

    }

    /***
     *Token 过期验证
     */
    private void requestRefreshTokenTask(){
        Request req = new Request(Util.jointUrl(UrlApi.ACCESS_TOKEN,UrlApi.WEB_MODEL_BASE)).setMethod(HttpMethod.Get).
                addUrlParam(Dict.CLIENT_ID,application.getToken().getClient_id())
                .addUrlParam(Dict.REFRESH_TOKEN,application.getToken().getRefresh_token());
        Response  response=client.execute(req);

        if (!Util.isEmpty(response.getString())){
            try {
                Token token=new Token();
                token=JSON.parseObject(response.getString(),Token.class);
                application.getToken().setAccess_token(token.getAccess_token());
                application.getToken().setExpires_in(token.getExpires_in());
                application.getToken().setRefresh_token(token.getRefresh_token());
            }catch (Exception e){

            }
        }
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
    }


    private void printLog(Response response) {
        if (response.getString() != null) com.litesuits.android.log.Log.i(TAG, "http result lengh : " + response.getString().length());
        com.litesuits.android.log.Log.v(TAG, "http result :\n " + response.getString());
        com.litesuits.android.log.Log.d(TAG, response.toString());
    }

}
