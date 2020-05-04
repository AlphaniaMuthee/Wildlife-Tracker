import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgress://ec2-52-207-25-133.compute-1.amazonaws.com:5432/dqhrjghhngdpq", "jpnwpfidtifdfl", "8208486c6a1d7b4fc4aab658e3571252200dd0979e447388da3c1651ddf49b18");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            String deleteEndangered_animalsQuery = "DELETE FROM endangered_animals *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteEndangered_animalsQuery).executeUpdate();
        }
    }
}
