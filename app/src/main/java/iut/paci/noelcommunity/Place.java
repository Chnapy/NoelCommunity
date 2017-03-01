package iut.paci.noelcommunity;

import org.mapsforge.core.model.LatLong;

import java.util.Date;

/**
 * Created by haddad1 on 27/02/2017.
 */
public abstract class Place {

    private final int id;
    private final String name;
    private final double longitude, latitude;
    private final Date openingTime, closingTime;

    public Place(int id, String name, double longitude, double latitude, Date openingTime, Date closingTime) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public abstract void drawMarker(MapActivity activity, LatLong geoPoint);

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
