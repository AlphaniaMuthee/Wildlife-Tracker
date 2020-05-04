import org.sql2o.*;
import java.util.List;

public class Endangered {
    private String name;
    private int id;
    private String health;
    private String age;

    public Endangered(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object otherEndangered) {
        if (!(otherEndangered instanceof Endangered)) {
            return false;
        } else {
            Endangered newEndangered= (Endangered) otherEndangered;
            return this.getName().equals(newEndangered.getName());
        }
    }

//    @Override
//    public void delete() {
//        String sql = "DELETE FROM endangered_animals";
//        try(Connection con = DB.sql2o.open()){
//            con.createQuery(sql)
//                    .executeUpdate();
//        }
//
//    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered_animals (name, health, age ) VALUES (:name :health :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }
    public List<Sightings> getSightings() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where endangeredId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }
    }

    public static List<Endangered> all() {
        String sql = "SELECT * FROM endangered_animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Endangered.class);
        }
    }
}
