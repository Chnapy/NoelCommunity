package iut.paci.noelcommunity;

import java.util.Date;

/**
 * Created by haddad1 on 27/02/2017.
 */
public class Store extends Place {

    private static final int ID_RESSOURCE = R.drawable.ic_place_store;

    private int treeCount;

    public Store(int id, String name, double longitude, double latitude, Date openingTime, Date closingTime, int treeCount) {
        super(id, name, longitude, latitude, openingTime, closingTime, ID_RESSOURCE);
        this.treeCount = treeCount;
    }

    public int getTreeCount() {
        return treeCount;
    }
}
