package com.wenshao.calculator.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wenshao.calculator.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.logo;
import static android.R.attr.radius;
import static android.R.attr.thickness;
import static com.wenshao.calculator.R.id.log;

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
        mFormulaList = new ArrayList<>();

        mIconFont = Typeface.createFromAsset(context.getAssets(), "iconfont/match-init.ttf");
        mPaint.setTypeface(mIconFont);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(80);

        int i = 100;
        for (String str : mFormulaList){
            canvas.drawText(str, i, i,mPaint);
            i=i+50;
        }
    }

    public void addText(CharSequence text) {
        mFormulaList.add(text.toString());
        invalidate();
    }
    public void setSelection(int start, int stop) {
        //Selection.setSelection(getText(), start, stop);
    }

    public void setSelection(int index) {
        //Selection.setSelection(getText(), index);
    }
}
