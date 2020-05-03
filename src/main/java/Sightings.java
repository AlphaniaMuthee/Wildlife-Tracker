import org.sql2o.*;

import java.util.List;
import java.sql.Timestamp;

public class Sightings {
    private String Location;
    private int animalId;
    private String rangerName;
    private int id;
    private Timestamp sighting;

    public Sightings(String location, String rangerName, int animalId) {
        Location = location;
        this.rangerName = rangerName;
        this.animalId = animalId;
    }

    public String getLocation() {
        return Location;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }

    public Timestamp getSighting() {
        return sighting;
    }

    @Override
    public boolean equals(Object otherSightings){
        if (!(otherSightings instanceof Sightings)) {
            return false;
        } else {
            Sightings newSightings = (Sightings) otherSightings;
            return this.getLocation().equals(newSightings.getLocation()) &&
                    this.getAnimalId() == newSightings.getAnimalId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, animalid , rangername, sighting) VALUES (:location, :animalId ,:rangerName , now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("location", this.Location)
                    .addParameter("animalId", this.animalId)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }

    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }
}
