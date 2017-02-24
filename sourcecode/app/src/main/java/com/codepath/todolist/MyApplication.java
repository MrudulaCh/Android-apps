package com.codepath.todolist;

import android.app.Application;

/**
 * Created by Pragiti on 2/17/2017.
 */

public class MyApplication extends Application {
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    }

