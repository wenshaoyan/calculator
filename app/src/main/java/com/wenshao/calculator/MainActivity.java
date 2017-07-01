package com.wenshao.calculator;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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


        /*final IconFontTextView font_log= (IconFontTextView)findViewById(R.id.font_log);

        font_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFont(font_log);
            }
        });*/




        //Log.i("===========", viewById.getText().toString());


    }

    public void clickFont(View view){
        IconFontTextView v = (IconFontTextView)view;
        //String str = IconFontTextView.symbolMap.get(v.getSymbol()).getSource();
        //String string = getResources().getString(R.string.icon_log);
        ed_input.addText(v.getSymbol());
        //ed_input.setText("&#xe6db;");
    }

}
