package de.vogella.jersey.first;

import java.io.File;
import java.io.FileNotFoundException;

import de.micromata.opengis.kml.v_2_2_0.Kml;

/**
 * @author Jason Axelson
 * 
 */
public class KmlTest {

  /**
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    // TODO Auto-generated method stub
    final Kml kml = new Kml();
    kml.createAndSetPlacemark().withName("London, UK").withOpen(Boolean.TRUE)
        .createAndSetPoint().addToCoordinates(-0.126236, 51.500152);
    kml.createAndSetPlacemark().withName("new name").withDescription("Time: 5pm")
        .withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(0, 0);
    kml.marshal(new File("HelloKml.kml"));
  }

}
