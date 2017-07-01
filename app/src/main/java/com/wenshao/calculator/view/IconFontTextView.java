package com.wenshao.calculator.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.wenshao.calculator.R;



/**
 * Created by wenshao on 2017/6/5.
 * iconFont字体类
 */
public class IconFontTextView extends TextView {
    private  final static String TAG = "IconFontTextView";
    private String symbol;


    public IconFontTextView(Context context) {
        this(context,null);
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface iconfont = Typeface.createFromAsset(context.getAssets(), "iconfont/match-init.ttf");
        setTypeface(iconfont);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.IconFontTextView);
        symbol = mTypedArray.getString(R.styleable.IconFontTextView_symbol);
        mTypedArray.getResources();
    }


    public void setSymbol(String s){
        symbol = s;
    }
    public String getSymbol(){
        return symbol;
    }



}
