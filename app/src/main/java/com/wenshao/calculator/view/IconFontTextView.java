package com.wenshao.calculator.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;

import com.wenshao.calculator.R;


/**
 * Created by wenshao on 2017/6/5.
 * iconFont字体类
 */
public class IconFontTextView extends TextView {
    private  final static String TAG = "IconFontTextView";
    private int symbol;

    public final static SparseArray symbolSet = new SparseArray();

    static {
        symbolSet.put(1,"log");
    }
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
        symbol = mTypedArray.getInt(R.styleable.IconFontTextView_symbol,0);
    }


    public void setSymbol(int s){
        symbol = s;
    }
    public int getSymbol(){
        return symbol;
    }



}
