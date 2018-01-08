package com.android.liyang.notificationinterceptor;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String mHasPermissionServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        initService();
    }

    private void initService() {
        this.startService(new Intent(this, NotificationServiceProxy.class));
    }

    private void initData() {
        mHasPermissionServices = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        String[] services = mHasPermissionServices.split(":");
        for (String service : services) {
            Logger.i(service);
        }
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn:
                onBtnClick();
                break;
            default:
                break;
        }
    }

    private void onBtnClick() {
        if (!TextUtils.isEmpty(mHasPermissionServices) &&
                !mHasPermissionServices.contains(NotificationServiceProxy.class.getSimpleName())) {
            this.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }
    }
}
