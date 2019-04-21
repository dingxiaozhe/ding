package com.example.geeknew.bean;

import java.io.Serializable;

public class GoldTitleBean implements Serializable{
    public  String title;
    public boolean isChecked;

    public GoldTitleBean(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }
}
