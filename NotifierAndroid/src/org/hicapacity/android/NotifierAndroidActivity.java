package org.hicapacity.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotifierAndroidActivity extends Activity {
  private Button but;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    but = (Button) this.findViewById(R.id.button1);
    but.setText("New text");
    but.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        System.out.println("Button pressed!");
        but.setText("newer text");
      }
    });
  }
}