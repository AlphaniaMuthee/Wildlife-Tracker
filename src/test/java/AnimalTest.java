import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void find_returnsAnimalWithSimilarId_secondAnimal() {
        Animal firstAnimal = new Animal("Monkey");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Warthog");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        Animal testAnimal = new Animal("Monkey");
        testAnimal.save();
        Sightings firstSightings = new Sightings("NE Quadrant", "Oscar", testAnimal.getId());
        firstSightings.save();
        Sightings secondSightings = new Sightings("SW Quadrant", "Sarah", testAnimal.getId());
        secondSightings.save();
        Sightings[] sightings = new Sightings[] { firstSightings, secondSightings };
        assertTrue(testAnimal.getSightings().containsAll(Arrays.asList(sightings)));
    }

}