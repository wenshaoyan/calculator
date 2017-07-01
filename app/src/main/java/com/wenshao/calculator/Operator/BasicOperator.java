package com.wenshao.calculator.operator;

/**
 * Created by wenshao on 2017/7/1.
 * 运算符基础类
 */


public class BasicOperator {
    private String name;    // 名称
    private String source;  // iconFont对应的source

    public BasicOperator(String name, String source) {
        this.name = name;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
