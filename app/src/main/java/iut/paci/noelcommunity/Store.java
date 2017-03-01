package iut.paci.noelcommunity;

import org.mapsforge.core.model.LatLong;

import java.util.Date;

/**
 * Created by haddad1 on 27/02/2017.
 */
public class Store extends Place {

    private int treeCount;

    public Store(int id, String name, double longitude, double latitude, Date openingTime, Date closingTime, int treeCount) {
        super(id, name, longitude, latitude, openingTime, closingTime);
        this.treeCount = treeCount;
    }

    public int getTreeCount() {
        return treeCount;
    }

    @Override
    public void drawMarker(MapActivity activity, LatLong geoPoint) {
        activity.drawMarker(R.drawable.ic_place_store, geoPoint);
    }

    @Override
    public String toString() {
        return "Store{\n" +
                super.toString() +
                "\ntreeCount=" + treeCount +
                '}';
    }
}
