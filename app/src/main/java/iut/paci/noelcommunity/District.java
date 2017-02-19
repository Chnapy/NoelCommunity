package iut.paci.noelcommunity;

/**
 * Created by haddad1 on 10/02/2017.
 */
public class District {

    private final int id;
    private final String nom;
    private final String description;
    private final int longitude;
    private final int latitude;
    private final int idImageRessource;

    public District(int id, String nom, String description, int longitude, int latitude, int idImageRessource) {
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

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
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
