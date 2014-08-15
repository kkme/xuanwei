package com.weixuan.football.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.fragment.PlayerAboutFragment;
import com.weixuan.football.fragment.PlayerGameStatsFragment;
import com.weixuan.football.fragment.PlayerRecordFragment;
import com.weixuan.football.fragment.PlayerRecordsHonorFragment;
import com.weixuan.football.util.Util;

/**
 * Created by Hua on 2014/8/13.
 */
public class TeamPlayerActivity extends BaseActivity {
    private TextView title;
    private View iv_back;
    public RadioGroup rgGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_player);
        initView();
    }


    @Override
    protected void initView() {
        this.iv_back=findViewById(R.id.iv_item_0);
        this.title=(TextView)findViewById(R.id.tv_title);
        this.rgGroup=(RadioGroup)findViewById(R.id.rg_group_m);
       Util.turnToFragment(getSupportFragmentManager(), PlayerAboutFragment.class,null,R.id.fl_m_content);
        rgGroup.check(R.id.rbtn_left_menu_0);
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbtn_left_menu_0:
                        Util.turnToFragment(getSupportFragmentManager(), PlayerAboutFragment.class,null,R.id.fl_m_content);
                        break;
                    case R.id.rbtn_left_menu_1:
                        Util.turnToFragment(getSupportFragmentManager(), PlayerGameStatsFragment.class,null,R.id.fl_m_content);
                        break;
                    case R.id.rbtn_left_menu_2:
                        Util.turnToFragment(getSupportFragmentManager(), PlayerRecordsHonorFragment.class,null,R.id.fl_m_content);
                        break;
                    case R.id.rbtn_left_menu_3:
                        Util.turnToFragment(getSupportFragmentManager(), PlayerRecordFragment.class,null,R.id.fl_m_content);
                        break;
                }
            }
        });
        this.iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setTitle(String title){
        this.title.setText(title);
    }
}
