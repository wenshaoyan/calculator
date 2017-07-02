package com.wenshao.calculator.operator;

import com.wenshao.calculator.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenshao on 2017/7/1.
 * 字符串对应的静态类
 */

public class SymbolMap {
    private final static Map<String,BasicOperator> symbolMap = new HashMap<String,BasicOperator>();

    static {

        // 添加数字
        symbolMap.put("1", new NumberOperator("1", R.string.icon_show_1));
        symbolMap.put("2", new NumberOperator("2", R.string.icon_show_2));
        symbolMap.put("3", new NumberOperator("3", R.string.icon_show_3));
        symbolMap.put("4", new NumberOperator("4", R.string.icon_show_4));
        symbolMap.put("5", new NumberOperator("5", R.string.icon_show_5));
        symbolMap.put("6", new NumberOperator("6", R.string.icon_show_6));
        symbolMap.put("7", new NumberOperator("7", R.string.icon_show_7));
        symbolMap.put("8", new NumberOperator("8", R.string.icon_show_8));
        symbolMap.put("9", new NumberOperator("9", R.string.icon_show_9));
        symbolMap.put("0", new NumberOperator("0", R.string.icon_show_0));

        // 添加字母
        symbolMap.put("x", new NumberOperator("", R.string.icon_show_x));
        symbolMap.put("y", new NumberOperator("", R.string.icon_show_y));
        symbolMap.put("z", new NumberOperator("", R.string.icon_show_z));

        // 添加运算符
        symbolMap.put("+", new NumberOperator("", R.string.icon_show_add));
        symbolMap.put("-", new NumberOperator("", R.string.icon_show_dec));
        symbolMap.put("*", new NumberOperator("", R.string.icon_show_ride));
        symbolMap.put("\\", new NumberOperator("", R.string.icon_show_div));






    }

    public static BasicOperator getOperator(String key){
        return symbolMap.get(key);
    }
}
