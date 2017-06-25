package com.wenshao.calculator.view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by wenshao on 2017/6/13.
 * 计算器输入框
 */

public class CalculatorEditText extends TextView{
    public CalculatorEditText(Context context) {
        super(context);
        init(context);

    }
    public CalculatorEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }
    public CalculatorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){

    }
    public void addText(CharSequence text){
        setSelection(2);
        super.setText(text, BufferType.EDITABLE);
    }

    @Override
    public CharSequence getText() {
        return super.getText();
    }

    public void setSelection(int start, int stop) {
        //Selection.setSelection(getText(), start, stop);
    }
    public void setSelection(int index) {
        //Selection.setSelection(getText(), index);
    }
}
