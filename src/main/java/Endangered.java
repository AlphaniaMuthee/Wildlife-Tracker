import org.sql2o.*;
import java.util.List;

public class Endangered {
    private String name;
    private int id;
    private String health;
    private String age;

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

    public Endangered(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }
}
