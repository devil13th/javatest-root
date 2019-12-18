package com.thd.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * com.thd.excel.DataBean
 *
 * @author: wanglei62
 * @DATE: 2019/11/21 17:52
 **/
public class DataBean {

    /**
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     * @ExcelProperty(index = 2)
     */

    @ExcelProperty("题干")
    private String title;
    @ExcelProperty("题型")
    private String type;
    @ExcelProperty("答案")
    private String answer;
    @ExcelProperty("A")
    private String a;
    @ExcelProperty("B")
    private String b;
    @ExcelProperty("C")
    private String c;
    @ExcelProperty("D")
    private String d;
    @ExcelProperty("E")
    private String e;
    @ExcelProperty("F")
    private String f;
    @ExcelProperty("G")
    private String g;



    @ExcelProperty("h")
    private String h;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", answer='" + answer + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                ", f='" + f + '\'' +
                ", g='" + g + '\'' +
                ", h='" + h + '\'' +
                '}';
    }
}
