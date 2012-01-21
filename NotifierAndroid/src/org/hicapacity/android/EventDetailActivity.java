package org.hicapacity.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Jason Axelson
 * 
 */
public class EventDetailActivity extends Activity {
  private TextView mTitleText;
  private TextView mDescriptionText;
  private TextView mTimeText;
  private Button mViewOnMapButton;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.event_detail);

    // Get references
    mTitleText = (TextView) this.findViewById(R.id.event_detail_title);
    mDescriptionText = (TextView) this.findViewById(R.id.event_detail_description);
    mTimeText = (TextView) this.findViewById(R.id.event_detail_time);
    mViewOnMapButton = (Button) this.findViewById(R.id.event_detail_view_on_map_button);

    Bundle bundle = getIntent().getExtras();
    System.out.println("saved state: " + savedInstanceState);
    System.out.println("bundle is: " + bundle);
    EventInfo eventInfo;
    if (bundle != null) {
      eventInfo = EventInfo.fromBundle(bundle);
      System.out.println("got event: " + eventInfo.toString());

      mTitleText.setText(eventInfo.getmTitle());
      mDescriptionText.setText(eventInfo.getmDescription());
      mTimeText.setText("Time: " + eventInfo.getmTime());

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
