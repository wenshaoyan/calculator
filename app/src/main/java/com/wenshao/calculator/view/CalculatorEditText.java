package com.wenshao.calculator.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;


import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wenshao on 2017/6/13.
 * 计算器输入框
 */

public class CalculatorEditText extends TextView {
    private Paint mPaint;
    private List<String> mFormulaList;
    private Typeface mIconFont;

    public CalculatorEditText(Context context) {
        this(context, null);
    }

    public CalculatorEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CalculatorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mFormulaList = new ArrayList<String>();

        mIconFont = Typeface.createFromAsset(context.getAssets(), "iconfont/match-init.ttf");
        mPaint.setTypeface(mIconFont);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(100);

        int i = 100;
        for (String str : mFormulaList){
            canvas.drawText(str, i, i,mPaint);
            //i=i+50;
        }
    }

    public void addText(String text) {
        //BasicOperator operator = SymbolMap.getOperator(text);
        mFormulaList.add("11");
        invalidate();
    }
    public void setSelection(int start, int stop) {
        //Selection.setSelection(getText(), start, stop);
    }

    public void setSelection(int index) {
        //Selection.setSelection(getText(), index);
    }
}
