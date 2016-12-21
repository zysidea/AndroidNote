package com.example.zys.toucheventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by zys on 16/10/27.
 */

public class LinearLayout1 extends LinearLayout {


    public LinearLayout1(Context context) {
        super(context);
    }

    public LinearLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayout1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("TAG", "dispatchTouchEvent: viewgroup1");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("TAG", "onInterceptTouchEvent: viewgroup1");
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TAG", "onTouchEvent: viewgroup1");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}
