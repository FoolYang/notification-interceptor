package com.android.liyang.notificationinterceptor;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by liyang on 18/1/8.
 */

public class NotificationServiceProxy extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        Log.i("notification_test", "NotificationServiceProxy, onNotificationPosted");
    }


    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        Log.i("notification_test", "NotificationServiceProxy, onNotificationRemoved");
    }
}
