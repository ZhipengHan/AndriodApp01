package com.example.zhhan.activitylifecycle;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private MyBinder myBinder = new MyBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "start IBinder...");
        return myBinder;
    }

    public void onCreate(){
        Log.e(TAG, "start onCreate...");
        super.onCreate();
    }

    public void onStart(Intent intent, int startId){
        Log.e(TAG, "start onStart...");
        super.onStart(intent, startId);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        int icon = R.drawable.notification_template_icon_bg;
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, "MyService Start...", when);
        Intent openintent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, openintent, 0);
        notification.setLatestEventInfo(this, "Title", "Content", pendingIntent);
        notificationManager.notify(0, notification);
    }

    public void onDestroy(){
        Log.e(TAG, "start onDestroy...");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent){
        Log.e(TAG, "start onUnbind...");
        return super.onUnbind(intent);
    }

    public String getSystemTime(){
        Time t = new Time();
        t.setToNow();
        return t.toString();
    }

    public class MyBinder extends Binder{
        MyService getServide(){
            return MyService.this;
        }
    }
}
