package org.hicapacity.android;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Jason Axelson
 * 
 */
public class EventDetailActivity extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.event_detail);

    Bundle bundle = getIntent().getExtras();
    System.out.println("saved state: " + savedInstanceState);
    System.out.println("bundle is: " + bundle);
    if (bundle != null) {
      String title = bundle.getString("title");
      if (title != null) {
        System.out.println("Title is: " + title);
      }
    }
    else {
      System.out.println("cannot load event since bundle is null");
    }
  }
}
