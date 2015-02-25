package com.dean.sparkscreen;

import android.os.Bundle;
import android.app.Activity;

/**
 * @author Dean Guo
 **/
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SparkView sparkView = new SparkView(this);
        setContentView(sparkView);
    }
    
}
