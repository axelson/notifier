package de.vogella.jersey.first;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;

/**
 * @author Jason Axelson
 * 
 */
public class DataSource {
  public static ArrayList<GeoEvent> sample() {
    long time = System.currentTimeMillis();
    ArrayList<GeoEvent> eventList = new ArrayList<GeoEvent>();

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

    eventList.add(new GeoEvent(21.38683, -157.930698, "Aiea", "Emergency Improvements", time,
        time + 100000));
    eventList.add(new GeoEvent(21.38099, -157.922115, "Halawa", "Sewer Reconstruction", time,
        time + 100000));
    eventList.add(new GeoEvent(21.29671, -157.701981, "Hawaii Kai", "Street Rehabilitation",
        time, time + 100000));
    eventList.add(new GeoEvent(21.31032, -157.857571, "Honolulu", "Sewer Rehabilitation",
        time, time + 100000));
    eventList.add(new GeoEvent(21.40624, -157.739639, "Kailua", "Sewer Rehabilitation", time,
        time + 100000));
    eventList.add(new GeoEvent(21.41296, -157.798347, "Kaneohe", "Road Rehabilitation", time,
        time + 100000));
    eventList.add(new GeoEvent(21.34646, -157.827358, "Nuuanu", "Bridge Rehabilitation", time,
        time + 100000));

    return eventList;
  }

  public static String convertToKml(List<GeoEvent> events) {
    final Kml kml = new Kml();
    Document document = kml.createAndSetDocument().withName("Document.kml").withOpen(true);
    for (GeoEvent event : events) {
      document.createAndAddPlacemark().withName(event.title)
          .withDescription(event.description).withOpen(Boolean.TRUE).createAndSetPoint()
          .addToCoordinates(event.lon, event.lat);
    }

    StringWriter stringWriter = new StringWriter();
    kml.marshal(stringWriter);
    String string = stringWriter.toString();

    return string;
  }

  public static String newSampleData() {
    ArrayList<GeoEvent> eventList = sample();
    String kml = convertToKml(eventList);
    return kml;
  }

  public static String getSampleData() {
    final Kml kml = new Kml();
    Document document = kml.createAndSetDocument().withName("Document.kml").withOpen(true);
    document.createAndAddPlacemark().withName("London, UK").withDescription("Description")
        .withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(-0.126236, 51.500152);
    document.createAndAddPlacemark().withName("Boston, US").withDescription("Description")
        .withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(-1.126236, 50.500152);

    StringWriter stringWriter = new StringWriter();
    kml.marshal(stringWriter);
    String string = stringWriter.toString();

    return string;
  }
}
