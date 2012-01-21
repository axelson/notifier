package de.vogella.jersey.first;

/**
 * @author Jason Axelson
 * 
 */
public class GeoEvent {
  public double lat;
  public double lon;
  public String title;
  public String description;
  public long startTime;
  public long endTime;

  /**
   * @param lat
   * @param lon
   * @param title
   * @param description
   * @param time
   */
  public GeoEvent(double lat, double lon, String title, String description, long startTime, long endTime) {
    super();
    this.lat = lat;
    this.lon = lon;
    this.title = title;
    this.description = description;
    this.startTime = startTime;
    this.endTime = endTime;
  }

}
