package com.atguigu.l04_datastorge;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById
    EditText et_name;
    @ViewById
    TextView tv_name;
    ProgressDialog pd;

    @AfterViews
    void init() {
        et_name.setText("11111");
    }

    @Click
    public void btn_download(View v) {
        pd = ProgressDialog.show(this, null, "正在下载中...");
        startDownload();
    }

    @Background
    void startDownload() {
        int a = 30;
        for (int i = 0; i < a; i++) {
            SystemClock.sleep(100);
            Log.e("TAG", "下载第" + i + "个数据");
        }
        upDateUI("下载完成啦！！！");
    }

    @UiThread
    void upDateUI(String msg) {
        tv_name.setText("下载完成");
        pd.dismiss();
    }
}
