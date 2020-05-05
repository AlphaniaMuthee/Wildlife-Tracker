import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgress://ec2-50-17-90-177.compute-1.amazonaws.com:5432/dajf96v5ptft26", "gauluvfvltjjbd", "b6e6967e7371a7ec0edaf36092e7c4fa55a291e9cb5e411f582cac00815bfb31");
        //DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "alphania", "2020");;
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
