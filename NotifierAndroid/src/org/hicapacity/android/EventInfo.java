package org.hicapacity.android;

import android.os.Bundle;

/**
 * @author Jason Axelson
 *
 */
public class EventInfo {
  public String TITLE_KEY = "title";
  public String DESCRIPTION_KEY = "description";
  public String COORDINATES_KEY = "coordinates";
  public String ADDRESS_KEY = "address";

  private String mTitle;
  private String mDescription;
  private String mCoordinates;
  private String mAddress;
  
  /**
   * @param mTitle
   * @param mDescription
   * @param mCoordinates
   * @param mAddress
   */
  public EventInfo(String mTitle, String mDescription, String mCoordinates, String mAddress) {
    super();
    this.mTitle = mTitle;
    this.mDescription = mDescription;
    this.mCoordinates = mCoordinates;
    this.mAddress = mAddress;
  }

  /**
   * @return the mTitle
   */
  public String getmTitle() {
    return mTitle;
  }

  /**
   * @param mTitle the mTitle to set
   */
  public void setmTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  /**
   * @return the mDescription
   */
  public String getmDescription() {
    return mDescription;
  }

  /**
   * @param mDescription the mDescription to set
   */
  public void setmDescription(String mDescription) {
    this.mDescription = mDescription;
  }

  /**
   * @return the mCoordinates
   */
  public String getmCoordinates() {
    return mCoordinates;
  }

  /**
   * @param mCoordinates the mCoordinates to set
   */
  public void setmCoordinates(String mCoordinates) {
    this.mCoordinates = mCoordinates;
  }

  /**
   * @return the mAddress
   */
  public String getmAddress() {
    return mAddress;
  }

  /**
   * @param mAddress the mAddress to set
   */
  public void setmAddress(String mAddress) {
    this.mAddress = mAddress;
  }
  
  public void storeInBundle(Bundle bundle) {
    bundle.putString(TITLE_KEY, mTitle);
    bundle.putString(DESCRIPTION_KEY, mDescription);
    bundle.putString(COORDINATES_KEY, mCoordinates);
    bundle.putString(ADDRESS_KEY, mAddress);
  }
  
  public EventInfo fromBundle(Bundle bundle) {
    String title = this.getStringOrError(bundle, TITLE_KEY);
    String description = this.getStringOrError(bundle, DESCRIPTION_KEY);
    String coordinates = this.getStringOrError(bundle, COORDINATES_KEY);
    String address = this.getStringOrError(bundle, ADDRESS_KEY);

    EventInfo eventInfo = new EventInfo(title, description, coordinates, address);
    return eventInfo;
  }
  
  private String getStringOrError(Bundle bundle, String key) {
    String string = bundle.getString(key);
    if(string == null) {
      throw new RuntimeException("Unable to get string for key: " + key);
    }
    return string;
  }
}
