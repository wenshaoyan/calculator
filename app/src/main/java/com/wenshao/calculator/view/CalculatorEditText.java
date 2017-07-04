package com.wenshao.calculator.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;


import android.util.Log;
import android.view.MotionEvent;

import android.widget.EditText;
import android.widget.TextView;

import com.wenshao.calculator.operator.BasicOperator;
import com.wenshao.calculator.operator.SymbolMap;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wenshao on 2017/6/13.
 * 计算器输入框
 */

public class CalculatorEditText extends TextView {
    private static final String TAG = "CalculatorEditText";


    private Paint mPaint;
    private List<BasicOperator> mFormulaList; // 所有运算符集合
    private Typeface mIconFont;  // 字体文件
    private List<CursorLocation> cursorLocations; // 光标可移动的位置
    private int currentCursorIndex; // 当前光标所在的光标数组的下标


    private int lastX;    // 上一次滑动的时候的x坐标
    private int lastY;    // 上一次滑动的时候的y坐标

    private int maxX;   // 当前最大的x坐标
    private int maxY;   // 当前最大的y坐标
    private int screenWidth;  // view控件占用的宽度


    private int moveX;
    private int moveY;

    private static final int startX = 50;
    private static final int startY = 100;

    private int currentCursorX;
    private int currentCursorY;


    public CalculatorEditText(Context context) {
        this(context, null);
    }

    public CalculatorEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CalculatorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mFormulaList = new ArrayList<>();

        mIconFont = Typeface.createFromAsset(context.getAssets(), "iconfont/match-init.ttf");
        mPaint.setTypeface(mIconFont);
        cursorLocations = new ArrayList<>();
    }

    private class CursorLocation {
        CursorLocation(float x, float y) {
            this.x = x;
            this.y = y;
        }

        float x;
        float y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        screenWidth = canvas.getWidth();
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(50);

        int x = startX;
        int y = startY;
        for (BasicOperator op : mFormulaList) {
            canvas.drawText(getResources().getString(op.getSource()), x, y, mPaint);
            CursorLocation cursorLocation = new CursorLocation(x, y);
            cursorLocations.add(cursorLocation);
            x += 50;
        }
        if (currentCursorX == 0) {
            currentCursorX = x;
            currentCursorY = y;
        }
        maxX = x;
        maxY = y;


        // 记录当前光标的位置
        currentCursorIndex = cursorLocations.size();

    }

    public void addText(String text) {
        BasicOperator operator = SymbolMap.getOperator(text);
        mFormulaList.add(operator);
        invalidate();
    }

    public void setSelection(int start, int stop) {
        //Selection.setSelection(getText(), start, stop);
    }

    public void setSelection(int index) {
        //Selection.setSelection(getText(), index);
    }

    public boolean onTouchEvent(MotionEvent event) {
        //获取到手指处的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (maxX < screenWidth) {   // 当前输入的宽度大于屏幕的宽度
            return true;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:

                //计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                int orientation = getOrientation(offsetX, offsetY);

                if ((maxX + moveX) < screenWidth && orientation == 'l') { // 判断是否可以左移
                    Log.i(TAG, "不允许左移动！" + getScrollX() + "--" + maxX + "---" + moveX);
                    //scrollTo(150, 0);
                    break;
                }
                if (moveX >= 0 && orientation == 'r') {  // 判断是否可以右移
                    Log.i(TAG, "不允许右移动！");
                    scrollTo(0, 0);
                    break;
                }
                maxX = maxX - offsetX;
                lastX = x;
                lastY = y;

                moveX += offsetX;
                moveY += offsetY;
                scrollBy(-offsetX, 0);

                break;
        }

        return true;
    }

    // 返回允许的移动的方向
    private String normal() {

        return "1";
    }


    /**
     * 根据距离差判断 滑动方向
     *
     * @param dx X轴的距离差
     * @param dy Y轴的距离差
     * @return 滑动的方向
     */
    private int getOrientation(float dx, float dy) {
        if (Math.abs(dx) > Math.abs(dy)) {
            //X轴移动
            return dx > 0 ? 'r' : 'l';
        } else {
            //Y轴移动
            return dy > 0 ? 'b' : 't';
        }
    }

    //TODO  屏幕移动字符串结尾
    private void screenEnd() {

    }


}
