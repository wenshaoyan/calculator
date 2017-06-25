package com.wenshao.calculator;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.wenshao.calculator.view.CalculatorEditText;
import com.wenshao.calculator.view.IconFontTextView;

public class MainActivity extends AppCompatActivity{
    private Context mContent;

    private CalculatorEditText ed_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = this;
        initUi();
    }

    private void initUi() {
        ed_input = (CalculatorEditText)findViewById(R.id.ed_input);


        final IconFontTextView font_log= (IconFontTextView)findViewById(R.id.font_log);

        font_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFont(font_log);
            }
        });




        //Log.i("===========", viewById.getText().toString());


    }

    private void clickFont(IconFontTextView v){
        String str = (String)IconFontTextView.symbolSet.get(v.getSymbol());
        String string = getResources().getString(R.string.icon_function);
        System.out.println(string);
        ed_input.addText(string);
        //ed_input.setText("&#xe6db;");
    }

}
