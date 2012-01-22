package org.hicapacity.android;

import java.util.ArrayList;

/**
 * @author Jason Axelson
 * 
 */
public class DataSource {
  public static ArrayList<GeoEventAndroid> sample() {
    long time = System.currentTimeMillis();
    ArrayList<GeoEventAndroid> eventList = new ArrayList<GeoEventAndroid>();

//    eventList.add(new GeoEvent(21.2362, -157.9028, "Road Closure",
//        "Closing the road for a long time", time, time + 100000));
//    eventList.add(new GeoEvent(21.7362, -156.9028, "MLK Parade",
//        "Closing the road for a long time", time, time + 100000));
//    eventList.add(new GeoEvent(-156.7362, 21.9028, "MLK Parade2",
//        "Closing the road for a long time", time, time + 100000));
//    eventList.add(new GeoEvent(-0.126236, 51.500152, "London, UK", "description stuff", time,
//        time + 100000));
//    eventList.add(new GeoEvent(-1.126236, 52.500152, "London, UK", "description stuff", time,
//        time + 100000));

    eventList.add(new GeoEventAndroid(21.38683, -157.930698, "Aiea", "Emergency Improvements", time,
        time + 100000));
    eventList.add(new GeoEventAndroid(21.38099, -157.922115, "Halawa", "Sewer Reconstruction", time,
        time + 100000));
    eventList.add(new GeoEventAndroid(21.29671, -157.701981, "Hawaii Kai", "Street Rehabilitation",
        time, time + 100000));
    eventList.add(new GeoEventAndroid(21.31032, -157.857571, "Honolulu", "Sewer Rehabilitation",
        time, time + 100000));
    eventList.add(new GeoEventAndroid(21.40624, -157.739639, "Kailua", "Sewer Rehabilitation", time,
        time + 100000));
    eventList.add(new GeoEventAndroid(21.41296, -157.798347, "Kaneohe", "Road Rehabilitation", time,
        time + 100000));
    eventList.add(new GeoEventAndroid(21.34646, -157.827358, "Nuuanu", "Bridge Rehabilitation", time,
        time + 100000));

    return eventList;
  }
}
