package iut.paci.noelcommunity;

import java.util.Date;

/**
 * Created by haddad1 on 27/02/2017.
 */
public class Deposite extends Place {

    private static final int ID_RESSOURCE = R.drawable.ic_place_deposite;

    private final int emptyCount;

    public Deposite(int id, String name, double longitude, double latitude, Date openingTime, Date closingTime, int emptyCount) {
        super(id, name, longitude, latitude, openingTime, closingTime, ID_RESSOURCE);
        this.emptyCount = emptyCount;
    }

    public int getEmptyCount() {
        return emptyCount;
    }
}
