package com.wenshao.calculator.operator;

/**
 * Created by wenshao on 2017/7/1.
 * 运算符基础类
 */


public class BasicOperator {
    private String name;    // 名称
    private int source;  // iconFont对应的source

    public BasicOperator(String name, int source) {
        this.name = name;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
