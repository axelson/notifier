package org.hicapacity.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotifierAndroidActivity extends Activity {
  private Button but;
  protected Activity activity = this;
  private static final int HELLO_ID = 1;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    but = (Button) this.findViewById(R.id.button1);
    but.setText("New text");
    Intent intent = new Intent(getApplicationContext(), NotifierAndroidActivity.class);

    but.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        System.out.println("Button pressed!");
        but.setText("newer text");

        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

        // TODO: use an official icon from Aaron
        int icon = R.drawable.icon;
        CharSequence tickerText = "Hello";
        long when = System.currentTimeMillis();

        Notification notification = new Notification(icon, tickerText, when);

        Context context = getApplicationContext();
        CharSequence contentTitle = "My notification";
        CharSequence contentText = "Hello World3!";
        Intent notificationIntent = new Intent(NotifierAndroidActivity.this,
            EventDetailActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(NotifierAndroidActivity.this,
            0, notificationIntent, 0);

        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

        mNotificationManager.notify(HELLO_ID, notification);
      }
    });
  }
}