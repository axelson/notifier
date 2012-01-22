package org.hicapacity.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class NotifierAndroidActivity extends ListActivity {
  private Button but;
  protected Activity activity = this;
  private static final int HELLO_ID = 1;
  private List<GeoEventAndroid> sEvents;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    but = (Button) this.findViewById(R.id.button1);
    // but.setText("New text");

    but.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        System.out.println("Button pressed!");
        // but.setText("newer text");
        restRequest();

        EventInfo eventInfo = new EventInfo("Honolulu",
            "Ongoing work on the sewer, no end in sight.", "21.38683, -157.930698", "",
            "ongoing");

        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

        int icon = R.drawable.notification_icon;
        CharSequence tickerText = eventInfo.getmTitle();
        long when = System.currentTimeMillis();

        Notification notification = new Notification(icon, tickerText, when);

        Context context = getApplicationContext();
        CharSequence contentTitle = eventInfo.getmTitle();
        CharSequence contentText = eventInfo.getmDescription();
        Intent notificationIntent = new Intent(NotifierAndroidActivity.this,
            EventDetailActivity.class);

        eventInfo.storeInIntent(notificationIntent);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
            | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // context.startActivity(notificationIntent);
        PendingIntent contentIntent = PendingIntent.getActivity(NotifierAndroidActivity.this,
            0, notificationIntent, 0);

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

        mNotificationManager.notify(HELLO_ID, notification);
      }
    });

    ArrayList<GeoEventAndroid> sample = DataSource.sample();
    EventAdapter adapter = new EventAdapter(this, sample);
    this.setListAdapter(adapter);

    ListView lv = getListView();
    lv.setTextFilterEnabled(true);
    sEvents = adapter.mEvents;

    lv.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        GeoEventAndroid event = sEvents.get(arg2);
        Intent notificationIntent = new Intent(NotifierAndroidActivity.this,
            EventDetailActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        EventInfo eventInfo = new EventInfo(event.title, event.description, "lat/long",
            "address", "ongoing");
        eventInfo.storeInIntent(notificationIntent);
        Context context = getApplicationContext();

        context.startActivity(notificationIntent);
      }
    });
  }

  private void restRequest() {
    System.out.println("trying to download");
    // UploadTest.testDownload();
    // UploadTest.testPost();
  }
}