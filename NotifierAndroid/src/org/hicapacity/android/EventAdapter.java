package org.hicapacity.android;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Jason Axelson
 * 
 */
public class EventAdapter extends BaseAdapter {
  public List<GeoEventAndroid> mEvents = new ArrayList<GeoEventAndroid>();
  Context mContext;

  /**
   * @param notifierAndroidActivity
   * @param sample
   */
  public EventAdapter(Context context, List<GeoEventAndroid> events) {
    mContext = context;
    mEvents = events;

  }

  /** {@inheritDoc} */
  @Override
  public int getCount() {
    return mEvents.size();
  }

  /** {@inheritDoc} */
  @Override
  public Object getItem(int position) {
    return this.mEvents.get(position);
  }

  /** {@inheritDoc} */
  @Override
  public long getItemId(int position) {
    // return this.mEvents.get(position).getId();
    return 0;
  }

  /** {@inheritDoc} */
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    final GeoEventAndroid truck = this.mEvents.get(position);

    RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(
        R.layout.foodtruck_list_item, parent, false);

    final TextView truckName = (TextView) itemLayout.findViewById(R.id.FoodTruckName);
    truckName.setText(truck.title);

    final TextView truckTwitter = (TextView) itemLayout.findViewById(R.id.FoodTruckTwitter);
    truckTwitter.setText(truck.description);

    final ImageView imageIcon = (ImageView) itemLayout.findViewById(R.id.FoodTruckIcon);

    // TODO Auto-generated method stub
    return itemLayout;
  }

}
