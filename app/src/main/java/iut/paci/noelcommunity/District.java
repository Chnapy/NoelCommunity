package iut.paci.noelcommunity;

import java.io.Serializable;

/**
 * Created by haddad1 on 10/02/2017.
 */
public class District implements Serializable {

    private final int id;
    private final String nom;
    private final String description;
    private final double longitude;
    private final double latitude;
    private final int idImageRessource;

    public District(int id, String nom, String description, double latitude, double longitude, int idImageRessource) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.idImageRessource = idImageRessource;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getIdImageRessource() {
        return idImageRessource;
    }

    public String toDialog() {
        return description
                + "\n\n"
                + "Position : (" + longitude + ";" + latitude + ")";
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", idImageRessource=" + idImageRessource +
                '}';
    }
}
