package iut.paci.noelcommunity;

import org.mapsforge.core.model.LatLong;

import java.util.Date;

/**
 * Created by haddad1 on 27/02/2017.
 */
public class Deposite extends Place {

    private final int emptyCount;

    public Deposite(int id, String name, double longitude, double latitude, Date openingTime, Date closingTime, int emptyCount) {
        super(id, name, longitude, latitude, openingTime, closingTime);
        this.emptyCount = emptyCount;
    }

    public int getEmptyCount() {
        return emptyCount;
    }

    @Override
    public void drawMarker(MapActivity activity, LatLong geoPoint) {
        activity.drawMarker(R.drawable.ic_place_deposite, geoPoint);
    }
}
