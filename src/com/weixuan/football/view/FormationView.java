package com.weixuan.football.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.entity.Formation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Hua on 2014/8/13.
 */
public class FormationView extends FrameLayout{

   public interface  OnItemClickListener{
        /****
         *
         * @param number 球号
         * @param flag  白队（true）  黄队（false）
         */
       public void   onItemClick(String number, boolean flag);
    }

    private OnItemClickListener onItemClickListener;

    public static final String TAG="FormationView";
    private static HashSet team;
    private List<TextView> lsView;

    /***  11名球员  ****/
    private HashMap<Integer,String> teamMapA=new HashMap<Integer, String>(11);
    private HashMap<Integer,String> teamMapB=new HashMap<Integer, String>(11);
    /***** 白红阵型 ****/
    private Formation writeFormation;
    private Formation yellowFormation;
    private int mWidth=80;
    /**球衣的宽高****/
    private int mHeight=60;
    /**  控件的宽高****/
    private int width;
    private int height;
    private int textSize=12;
    /***
     * 初始化控件和数据
     */
    public void initData(int width,int height){
        this.width=width;
        this.height=height;
        init();
        lsView=new ArrayList<TextView>(22);

        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(mWidth,mHeight);
        int halfHeight=height/2+mHeight;
        /******1*********/
        lsView.add(createView(mWidth / 2,height/2+mHeight,teamMapA.get(1),params,true));
        int aWidth=width / 4-mWidth/2;
        int bWidth=width / 4+mWidth;
        int cWidth=bWidth+mWidth+30;
        /******************白队****************/
        switch (writeFormation.getaValue()){
            case 5:  /******  532 ***541 ********/
                lsView.add(createView(aWidth,height/5,teamMapA.get(2),params,true));
                lsView.add(createView(aWidth,height/5*2,teamMapA.get(6),params,true));
                lsView.add(createView(aWidth,height/5*3+20,teamMapA.get(5),params,true));
                lsView.add(createView(aWidth,height/5*4+30,teamMapA.get(4),params,true));
                lsView.add(createView(aWidth,height+30,teamMapA.get(3),params,true));
                if (writeFormation.getbValue()==3){
                    lsView.add(createView(bWidth,height/3,teamMapA.get(7),params,true));
                    lsView.add(createView(bWidth,height/3*2-20,teamMapA.get(8),params,true));
                    lsView.add(createView(bWidth,height,teamMapA.get(11),params,true));

                    lsView.add(createView(bWidth+mWidth+30,halfHeight-mHeight,teamMapA.get(10),params,true));
                    lsView.add(createView(bWidth+mWidth+30,halfHeight+mHeight,teamMapA.get(9),params,true));
                }else{
                    lsView.add(createView(bWidth,height/4,teamMapA.get(7),params,true));
                    lsView.add(createView(bWidth,height/4*2,teamMapA.get(8),params,true));
                    lsView.add(createView(bWidth,height/4*3,teamMapA.get(10),params,true));
                    lsView.add(createView(bWidth,height,teamMapA.get(11),params,true));

                    lsView.add(createView(bWidth+mWidth+30,halfHeight,teamMapA.get(9),params,true));
                }
                break;
            case 4:
                lsView.add(createView(aWidth,height/4,teamMapA.get(2),params,true));
                lsView.add(createView(aWidth,height/4*2,teamMapA.get(5),params,true));
                lsView.add(createView(aWidth,height/4*3,teamMapA.get(6),params,true));
                lsView.add(createView(aWidth,height,teamMapA.get(3),params,true));
                switch (writeFormation.getbValue()){
                    case 5:
                        /*********451*********/
                        lsView.add(createView(bWidth,height/5,teamMapA.get(7),params,true));
                        lsView.add(createView(bWidth,height/5*2,teamMapA.get(4),params,true));
                        lsView.add(createView(bWidth,halfHeight,teamMapA.get(10),params,true));
                        lsView.add(createView(bWidth,height/5*4+30,teamMapA.get(8),params,true));
                        lsView.add(createView(bWidth,height+30,teamMapA.get(11),params,true));
                        lsView.add(createView(bWidth+mWidth+30,halfHeight,teamMapA.get(9),params,true));
                        break;
                    case 4:
                        /*********442****4411*****/
                        lsView.add(createView(bWidth,height/4,teamMapA.get(7),params,true));
                        lsView.add(createView(bWidth,height/4*2,teamMapA.get(4),params,true));
                        lsView.add(createView(bWidth,height/4*3,teamMapA.get(8),params,true));
                        lsView.add(createView(bWidth,height,teamMapA.get(11),params,true));
                        if (writeFormation.getcValue()==2){
                            lsView.add(createView(bWidth+mWidth+30,halfHeight-mHeight,teamMapA.get(10),params,true));
                            lsView.add(createView(bWidth+mWidth+30,halfHeight+mHeight,teamMapA.get(9),params,true));
                        }else {
                            lsView.add(createView(bWidth+mWidth-20,halfHeight,teamMapA.get(10),params,true));

                            lsView.add(createView(bWidth+mWidth+60,halfHeight,teamMapA.get(9),params,true));
                        }
                        break;
                    case 3:
                        /****433*****4321***************/

                        if(writeFormation.getcValue()==3) {
                            lsView.add(createView(bWidth, height / 3, teamMapA.get(7), params, true));
                            lsView.add(createView(bWidth, height / 3 * 2 - 30, teamMapA.get(4), params, true));
                            lsView.add(createView(bWidth, height - 30, teamMapA.get(8), params, true));

                            lsView.add(createView(cWidth, height / 3, teamMapA.get(10), params, true));
                            lsView.add(createView(cWidth, height / 3 * 2 - 30, teamMapA.get(9), params, true));
                            lsView.add(createView(cWidth, height - 30, teamMapA.get(11), params, true));
                        }else {
                            bWidth=bWidth-20;
                            lsView.add(createView(bWidth, height / 3, teamMapA.get(8), params, true));
                            lsView.add(createView(bWidth, height / 3 * 2 - 30, teamMapA.get(4), params, true));
                            lsView.add(createView(bWidth, height - 30, teamMapA.get(7), params, true));
                            cWidth=bWidth+mWidth;
                            lsView.add(createView(bWidth, halfHeight-mHeight-30, teamMapA.get(10), params, true));
                            lsView.add(createView(cWidth, halfHeight+mHeight+30, teamMapA.get(11), params, true));

                            lsView.add(createView(cWidth+mWidth, halfHeight, teamMapA.get(9), params, true));
                        }
                        break;
                    case 2:
                        /*****4231*********4222*********************/
                        if(writeFormation.getcValue()==3) {
                            bWidth = bWidth - 40;
                            lsView.add(createView(bWidth, halfHeight - mHeight - 20, teamMapA.get(8), params, true));
                            lsView.add(createView(bWidth, halfHeight + mHeight + 20, teamMapA.get(4), params, true));

                            lsView.add(createView(bWidth + mWidth, height / 3, teamMapA.get(7), params, true));
                            lsView.add(createView(bWidth + mWidth, height / 3 * 2 - 30, teamMapA.get(10), params, true));
                            lsView.add(createView(bWidth + mWidth, height - 30, teamMapA.get(11), params, true));

                            lsView.add(createView(cWidth + 20, halfHeight, teamMapA.get(9), params, true));
                        }else {
                            lsView.add(createView(bWidth, halfHeight - mHeight - 20, teamMapA.get(4), params, true));
                            lsView.add(createView(bWidth, halfHeight + mHeight + 20, teamMapA.get(8), params, true));

                            lsView.add(createView(bWidth + mWidth, halfHeight-mHeight*2-30, teamMapA.get(7), params, true));
                            lsView.add(createView(bWidth + mWidth, halfHeight+mHeight*2+30, teamMapA.get(11), params, true));

                            lsView.add(createView(cWidth+20, halfHeight - mHeight, teamMapA.get(10), params, true));
                            lsView.add(createView(cWidth + 20, halfHeight+mHeight, teamMapA.get(9), params, true));
                        }
                        break;
                    case 1: /*********4141**********41212*************************/
                        lsView.add(createView(bWidth - 30, halfHeight, teamMapA.get(4), params, true));
                        if(writeFormation.geteValue()==2) {
                            lsView.add(createView(bWidth, halfHeight - mHeight * 2 - 30, teamMapA.get(7), params, true));
                            lsView.add(createView(bWidth, halfHeight + mHeight * 2 + 30, teamMapA.get(11), params, true));

                            lsView.add(createView(bWidth + mWidth, halfHeight, teamMapA.get(8), params, true));

                            lsView.add(createView(cWidth + 20, halfHeight - mHeight * 2 - 30, teamMapA.get(10), params, true));
                            lsView.add(createView(cWidth + 20, halfHeight + mHeight * 2 + 30, teamMapA.get(9), params, true));
                        }else {
                            bWidth=bWidth+20;
                            lsView.add(createView(bWidth, height/4 ,teamMapA.get(7), params, true));
                            lsView.add(createView(bWidth, height/4*2 , teamMapA.get(8), params, true));
                            lsView.add(createView(bWidth, height/4*3, teamMapA.get(11), params, true));
                            lsView.add(createView(bWidth, height, teamMapA.get(9), params, true));

                            lsView.add(createView(cWidth, halfHeight, teamMapA.get(9), params, true));
                        }
                        break;
                }
                break;
            case 3 /*****352****343******31312*********3511**********3421*********3412*************/:
                lsView.add(createView(aWidth,height/3-30,teamMapA.get(6),params,true));
                lsView.add(createView(aWidth,halfHeight,teamMapA.get(5),params,true));
                lsView.add(createView(aWidth,height,teamMapA.get(4),params,true));
                switch (writeFormation.getbValue()){
                    case 5: /****271183***10 9*10* 9   **/
                        lsView.add(createView(bWidth, height/5 ,teamMapA.get(2), params, true));
                        lsView.add(createView(bWidth, height/5*2 , teamMapA.get(7), params, true));
                        lsView.add(createView(bWidth, halfHeight, teamMapA.get(11), params, true));
                        lsView.add(createView(bWidth, height/5*4+20, teamMapA.get(8), params, true));
                        lsView.add(createView(bWidth, height+30, teamMapA.get(3), params, true));
                        if (writeFormation.getcValue()==2){
                            lsView.add(createView(cWidth, halfHeight-mWidth, teamMapA.get(10), params, true));
                            lsView.add(createView(cWidth, halfHeight+mWidth, teamMapA.get(9), params, true));
                        }else {
                            lsView.add(createView(bWidth+70, halfHeight-mWidth+10, teamMapA.get(10), params, true));
                            lsView.add(createView(cWidth+20, halfHeight+mWidth, teamMapA.get(9), params, true));
                        }
                        break;
                    case 4:/********343**2783 10911*****3421*********3412************31312*******/
                        lsView.add(createView(bWidth, height/4 ,teamMapA.get(2), params, true));
                        lsView.add(createView(bWidth, height/4*2 , teamMapA.get(7), params, true));
                        lsView.add(createView(bWidth,  height/4*3, teamMapA.get(8), params, true));
                        lsView.add(createView(bWidth, height, teamMapA.get(3), params, true));
                        switch (writeFormation.getcValue()) {
                            case 3:
                                lsView.add(createView(cWidth, height / 3, teamMapA.get(10), params, true));
                                lsView.add(createView(cWidth, halfHeight, teamMapA.get(9), params, true));
                                lsView.add(createView(cWidth, height - 40, teamMapA.get(11), params, true));
                                break;
                            case 2:
                                cWidth=cWidth-40;
                                lsView.add(createView(cWidth, height / 3, teamMapA.get(10), params, true));
                                lsView.add(createView(cWidth, height - 40, teamMapA.get(9), params, true));
                                lsView.add(createView(cWidth+60, halfHeight, teamMapA.get(11), params, true));
                                break;
                            case 1:
                                cWidth=cWidth-40;
                                lsView.add(createView(cWidth, halfHeight, teamMapA.get(9), params, true));

                                lsView.add(createView(cWidth+60, height / 3+10, teamMapA.get(10), params, true));
                                lsView.add(createView(cWidth+60, height - 30, teamMapA.get(11), params, true));
                                break;
                        }
                        break;
                    case 1:/******************31312*******7 283 9 11******************/
                        bWidth=bWidth-40;
                        lsView.add(createView(bWidth, halfHeight +50,teamMapA.get(7), params, true));

                        lsView.add(createView(bWidth+40, height / 3-20, teamMapA.get(2), params, true));
                        lsView.add(createView(bWidth+40,height/2, teamMapA.get(8), params, true));
                        lsView.add(createView(bWidth+40, height - 40, teamMapA.get(3), params, true));

                        lsView.add(createView(cWidth-20, halfHeight, teamMapA.get(9), params, true));

                        lsView.add(createView(cWidth+20, halfHeight-mWidth-40 ,teamMapA.get(10), params, true));
                        lsView.add(createView(cWidth+20, halfHeight+mWidth+40 ,teamMapA.get(11), params, true));
                        break;
                }
                break;
        }

        /****************黄队******************/
        int aWidth_=width-aWidth+30;
        int bWidth_=width-bWidth;
        int cWidth_=width-(bWidth+mWidth+30);
        switch (yellowFormation.getaValue()){
            case 5:  /******  532 ***541 ********/
                lsView.add(createView(aWidth_,height/5,teamMapB.get(2),params,false));
                lsView.add(createView(aWidth_,height/5*2,teamMapB.get(6),params,false));
                lsView.add(createView(aWidth_,height/5*3+20,teamMapB.get(5),params,false));
                lsView.add(createView(aWidth_,height/5*4+30,teamMapB.get(4),params,false));
                lsView.add(createView(aWidth_,height+30,teamMapB.get(3),params,false));
                if (yellowFormation.getbValue()==3){
                    lsView.add(createView(bWidth_,height/3,teamMapB.get(7),params,false));
                    lsView.add(createView(bWidth_,height/3*2-20,teamMapB.get(8),params,false));
                    lsView.add(createView(bWidth_,height,teamMapB.get(11),params,false));

                    lsView.add(createView(bWidth_-mWidth-10,halfHeight-mHeight,teamMapB.get(10),params,false));
                    lsView.add(createView(bWidth_-mWidth-10,halfHeight+mHeight,teamMapB.get(9),params,false));
                }else{
                    lsView.add(createView(bWidth_,height/4,teamMapB.get(7),params,false));
                    lsView.add(createView(bWidth_,height/4*2,teamMapB.get(8),params,false));
                    lsView.add(createView(bWidth_,height/4*3,teamMapB.get(10),params,false));
                    lsView.add(createView(bWidth_,height,teamMapB.get(11),params,false));

                    lsView.add(createView(bWidth_-mWidth+30,halfHeight,teamMapB.get(9),params,false));
                }
                break;
            case 4:
                lsView.add(createView(aWidth_,height/4,teamMapB.get(2),params,false));
                lsView.add(createView(aWidth_,height/4*2,teamMapB.get(5),params,false));
                lsView.add(createView(aWidth_,height/4*3,teamMapB.get(6),params,false));
                lsView.add(createView(aWidth_,height,teamMapB.get(3),params,false));
                switch (yellowFormation.getbValue()){
                    case 5:
                        /*********451*********/
                        lsView.add(createView(bWidth_,height/5,teamMapB.get(7),params,false));
                        lsView.add(createView(bWidth_,height/5*2,teamMapB.get(4),params,false));
                        lsView.add(createView(bWidth_,halfHeight,teamMapB.get(10),params,false));
                        lsView.add(createView(bWidth_,height/5*4+30,teamMapB.get(8),params,false));
                        lsView.add(createView(bWidth_,height+30,teamMapB.get(11),params,false));

                        lsView.add(createView(bWidth_-mWidth-30,halfHeight,teamMapB.get(9),params,false));
                        break;
                    case 4:
                        /*********442****4411*****/
                        lsView.add(createView(bWidth_,height/4,teamMapB.get(7),params,false));
                        lsView.add(createView(bWidth_,height/4*2,teamMapB.get(4),params,false));
                        lsView.add(createView(bWidth_,height/4*3,teamMapB.get(8),params,false));
                        lsView.add(createView(bWidth_,height,teamMapB.get(11),params,false));
                        if (yellowFormation.getcValue()==2){
                            lsView.add(createView(bWidth_-mWidth-30,halfHeight-mHeight,teamMapB.get(10),params,false));
                            lsView.add(createView(bWidth_-mWidth-30,halfHeight+mHeight,teamMapB.get(9),params,false));
                        }else {
                            lsView.add(createView(bWidth_-mWidth+20,halfHeight,teamMapB.get(10),params,false));

                            lsView.add(createView(bWidth_-mWidth-60,halfHeight,teamMapB.get(9),params,false));
                        }
                        break;
                    case 3:
                        /****433*****4321***************/

                        if(yellowFormation.getcValue()==3) {
                            lsView.add(createView(bWidth_, height / 3, teamMapB.get(7), params, false));
                            lsView.add(createView(bWidth_, height / 3 * 2 - 30, teamMapB.get(4), params, false));
                            lsView.add(createView(bWidth_, height - 30, teamMapB.get(8), params, false));

                            lsView.add(createView(cWidth_, height / 3, teamMapB.get(10), params, false));
                            lsView.add(createView(cWidth_, height / 3 * 2 - 30, teamMapB.get(9), params, false));
                            lsView.add(createView(cWidth_, height - 30, teamMapB.get(11), params, false));
                        }else {
                            bWidth_=bWidth_+20;
                            lsView.add(createView(bWidth_, height / 3, teamMapB.get(8), params, false));
                            lsView.add(createView(bWidth_, height / 3 * 2 - 30, teamMapB.get(4), params, false));
                            lsView.add(createView(bWidth_, height - 30, teamMapB.get(7), params, false));
                            cWidth_=bWidth_-mWidth;
                            lsView.add(createView(cWidth_, halfHeight-mHeight-30, teamMapB.get(10), params, false));
                            lsView.add(createView(cWidth_, halfHeight+mHeight+30, teamMapB.get(11), params, false));

                            lsView.add(createView(cWidth_-mWidth+10, halfHeight, teamMapB.get(9), params, false));
                        }
                        break;
                    case 2:
                        /*****4231*********4222*********************/
                        if(yellowFormation.getcValue()==3) {
                            bWidth_ = bWidth_ +40;
                            lsView.add(createView(bWidth_, halfHeight - mHeight - 20, teamMapB.get(8), params, false));
                            lsView.add(createView(bWidth_, halfHeight + mHeight + 20, teamMapB.get(4), params, false));

                            lsView.add(createView(bWidth_ -mWidth, height / 3, teamMapB.get(7), params, false));
                            lsView.add(createView(bWidth_ - mWidth, height / 3 * 2 - 30, teamMapB.get(10), params, false));
                            lsView.add(createView(bWidth_ - mWidth, height - 30, teamMapB.get(11), params, false));

                            lsView.add(createView(cWidth_ -20, halfHeight, teamMapB.get(9), params, false));
                        }else {
                            lsView.add(createView(bWidth_, halfHeight - mHeight - 20, teamMapB.get(4), params, false));
                            lsView.add(createView(bWidth_, halfHeight + mHeight + 20, teamMapB.get(8), params, false));

                            lsView.add(createView(bWidth_ - mWidth, halfHeight-mHeight*2-30, teamMapB.get(7), params, false));
                            lsView.add(createView(bWidth_ - mWidth, halfHeight+mHeight*2+30, teamMapB.get(11), params, false));

                            lsView.add(createView(cWidth_-20, halfHeight - mHeight, teamMapB.get(10), params, false));
                            lsView.add(createView(cWidth_-20, halfHeight+mHeight, teamMapB.get(9), params, false));
                        }
                        break;
                    case 1: /*********4141**********41212*************************/
                        lsView.add(createView(bWidth_ +30, halfHeight, teamMapB.get(4), params, false));
                        if(yellowFormation.geteValue()==2) {
                            lsView.add(createView(bWidth_, halfHeight - mHeight * 2 - 30, teamMapB.get(7), params, false));
                            lsView.add(createView(bWidth_, halfHeight + mHeight * 2 + 30, teamMapB.get(11), params, false));

                            lsView.add(createView(bWidth_ -mWidth, halfHeight, teamMapB.get(8), params, false));

                            lsView.add(createView(cWidth_-20, halfHeight - mHeight * 2 - 30, teamMapB.get(10), params, false));
                            lsView.add(createView(cWidth_ -20, halfHeight + mHeight * 2 + 30, teamMapB.get(9), params, false));
                        }else {
                            bWidth_=bWidth_-30;
                            lsView.add(createView(bWidth_, height/4 ,teamMapB.get(7), params, false));
                            lsView.add(createView(bWidth_, height/4*2 , teamMapB.get(8), params, false));
                            lsView.add(createView(bWidth_, height/4*3, teamMapB.get(11), params, false));
                            lsView.add(createView(bWidth_, height, teamMapB.get(9), params, false));

                            lsView.add(createView(cWidth_-20, halfHeight, teamMapB.get(9), params, false));
                        }
                        break;
                }
                break;
            case 3 /*****352****343******31312*********3511**********3421*********3412*************/:
                lsView.add(createView(aWidth_,height/3-30,teamMapB.get(6),params,false));
                lsView.add(createView(aWidth_,halfHeight,teamMapB.get(5),params,false));
                lsView.add(createView(aWidth_,height,teamMapB.get(4),params,false));
                switch (yellowFormation.getbValue()){
                    case 5: /****271183***10 9*10* 9   **/
                        lsView.add(createView(bWidth_, height/5 ,teamMapB.get(2), params, false));
                        lsView.add(createView(bWidth_, height/5*2 , teamMapB.get(7), params, false));
                        lsView.add(createView(bWidth_, halfHeight, teamMapB.get(11), params, false));
                        lsView.add(createView(bWidth_, height/5*4+20, teamMapB.get(8), params, false));
                        lsView.add(createView(bWidth_, height+30, teamMapB.get(3), params, false));
                        if (yellowFormation.getcValue()==2){
                            lsView.add(createView(cWidth_, halfHeight-mWidth, teamMapB.get(10), params, false));
                            lsView.add(createView(cWidth_, halfHeight+mWidth, teamMapB.get(9), params, false));
                        }else {
                            lsView.add(createView(cWidth_+40, halfHeight-mWidth+10, teamMapB.get(10), params, false));
                            lsView.add(createView(cWidth_-20, halfHeight+mWidth, teamMapB.get(9), params, false));
                        }
                        break;
                    case 4:/********343**2783 10911*****3421*********3412************31312*******/
                        lsView.add(createView(bWidth_, height/4 ,teamMapB.get(2), params, false));
                        lsView.add(createView(bWidth_, height/4*2 , teamMapB.get(7), params, false));
                        lsView.add(createView(bWidth_,  height/4*3, teamMapB.get(8), params, false));
                        lsView.add(createView(bWidth_, height, teamMapB.get(3), params, false));
                        switch (yellowFormation.getcValue()) {
                            case 3:
                                lsView.add(createView(cWidth_, height / 3, teamMapB.get(10), params, false));
                                lsView.add(createView(cWidth_, halfHeight, teamMapB.get(9), params, false));
                                lsView.add(createView(cWidth_, height - 40, teamMapB.get(11), params, false));
                                break;
                            case 2:
                                cWidth_=cWidth_+40;
                                lsView.add(createView(cWidth_, height / 3, teamMapB.get(10), params, false));
                                lsView.add(createView(cWidth_, height - 40, teamMapB.get(9), params, false));
                                lsView.add(createView(cWidth_-60, halfHeight, teamMapB.get(11), params, false));
                                break;
                            case 1:
                                cWidth_=cWidth_+40;
                                lsView.add(createView(cWidth_, halfHeight, teamMapB.get(9), params, false));

                                lsView.add(createView(cWidth_-60, height / 3+10, teamMapB.get(10), params, false));
                                lsView.add(createView(cWidth_-60, height - 30, teamMapB.get(11), params, false));
                                break;
                        }
                        break;
                    case 1:/******************31312*******7 283 9 11******************/
                        bWidth_=bWidth_+40;
                        lsView.add(createView(bWidth_, halfHeight +50,teamMapB.get(7), params, false));

                        lsView.add(createView(bWidth_-40, height / 3-20, teamMapB.get(2), params, false));
                        lsView.add(createView(bWidth_-40,height/2, teamMapB.get(8), params, false));
                        lsView.add(createView(bWidth_-40, height - 40, teamMapB.get(3), params, false));

                        lsView.add(createView(cWidth_+40, halfHeight, teamMapB.get(9), params, false));

                        lsView.add(createView(cWidth_-20, halfHeight-mWidth-40 ,teamMapB.get(10), params, false));
                        lsView.add(createView(cWidth_-20, halfHeight+mWidth ,teamMapB.get(11), params, false));
                        break;
                }
                break;
        }




        /******21*********/
        lsView.add(createView(width,halfHeight,teamMapA.get(1),params,false));
        for (TextView view:lsView){
            addView(view);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(((TextView)v).getText().toString(),Boolean.parseBoolean(v.getTag().toString()));
                }
            });
        }
    }

    private void init(){
        writeFormation=new Formation(31312);
        yellowFormation=new Formation(31312);
        teamMapA.put(1,"1");
        teamMapA.put(2,"2");
        teamMapA.put(3,"3");
        teamMapA.put(4,"4");
        teamMapA.put(5,"5");
        teamMapA.put(6,"6");
        teamMapA.put(7,"7");
        teamMapA.put(8,"8");
        teamMapA.put(9,"9");
        teamMapA.put(10,"10");
        teamMapA.put(11,"11");
        teamMapB.put(1,"1");
        teamMapB.put(2,"2");
        teamMapB.put(3,"3");
        teamMapB.put(4,"4");
        teamMapB.put(5,"5");
        teamMapB.put(6,"6");
        teamMapB.put(7,"7");
        teamMapB.put(8,"8");
        teamMapB.put(9,"9");
        teamMapB.put(10,"10");
        teamMapB.put(11,"11");
    }

    /***
     *
     * @param x
     * @param y
     * @param text
     * @param params
     * @param flag 判断是否白队（true）  黄队（false）
     * @return
     */
    private TextView createView(int x,int y,String text,ViewGroup.LayoutParams params,boolean flag){
        TextView textView=new TextView(getContext());
        textView.setText(text);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(textSize);
        textView.setTag(flag);
        if (flag) {
            textView.setBackgroundResource(R.drawable.icon_white_team);
        }else {
            textView.setBackgroundResource(R.drawable.icon_yellow_team);
        }
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setX(x);
        textView.setY(y);
        return textView;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public FormationView(Context context) {
        super(context);
    }

    public FormationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    static {
        team=new HashSet();
        team.add(532);
        team.add(541);
        team.add(4222);
        team.add(442);
        team.add(41212);
        team.add(451);
        team.add(433);
        team.add(4411);
        team.add(4141);
        team.add(4231);
        team.add(4321);
        team.add(352);
        team.add(343);
        team.add(31312);
        team.add(3412);
        team.add(3421);
        team.add(3511);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public HashMap<Integer, String> getTeamMapA() {
        return teamMapA;
    }

    public void setTeamMapA(HashMap<Integer, String> teamMapA) {
        this.teamMapA = teamMapA;
    }

    public HashMap<Integer, String> getTeamMapB() {
        return teamMapB;
    }

    public void setTeamMapB(HashMap<Integer, String> teamMapB) {
        this.teamMapB = teamMapB;
    }

    public Formation getWriteFormation() {
        return writeFormation;
    }

    public void setWriteFormation(Formation writeFormation) {
        this.writeFormation = writeFormation;
    }

    public Formation getYellowFormation() {
        return yellowFormation;
    }

    public void setYellowFormation(Formation yellowFormation) {
        this.yellowFormation = yellowFormation;
    }
}