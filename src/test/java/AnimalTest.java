import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Monkey");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void equals_returnsTrueIfNameAndIdAreSame_true() {
        Animal firstAnimal = new Animal("Monkey");
        Animal anotherAnimal = new Animal("Monkey");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
       Animal firstAnimal = new Animal("Monkey");
       firstAnimal.save();
       Animal secondAnimal = new Animal("Warthog");
       secondAnimal.save();
       assertEquals(true, Animal.all().get(0).equals(firstAnimal));
       assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Monkey");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

}