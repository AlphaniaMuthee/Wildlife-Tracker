import org.junit.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightings_InstantiatesCorrectly_true() {
        Sightings testSightings = new Sightings ("NE Quadrant","Oscar",1);
        assertEquals(true, testSightings instanceof Sightings );
    }

    @Test
    public void sightings_instantiateWithLocation_String(){
        Sightings testSightings = new Sightings ("NE Quadrant", "Oscar", 1);
        assertEquals("NE Quadrant", testSightings.getLocation());
    }

    @Test
    public void sightings_instantiateWithAnimalId_int(){
        Sightings testSightings = new Sightings("NE Quadrant", "Oscar", 1);
        assertEquals(1, testSightings.getAnimalId());
    }

    @Test
    public void equals_returnsTrueIfLocationAndAnimalIdAreSAme_true() {
        Sightings testSightings = new Sightings ("NE Quadrant", "Oscar", 1);
        Sightings anotherSightings = new Sightings ("NE Quadrant", "Oscar", 1);
        assertTrue(testSightings.equals(anotherSightings));
    }

    @Test
    public void save_assignsIdToSighting() {
        Sightings testSightings = new Sightings ("NE Quadrant", "Oscar", 1);
        testSightings.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(savedSightings.getId(), testSightings.getId());
    }

    @Test
    public void find_returnsSightingsWithSameId_secondSighting() {
        Sightings firstSightings = new Sightings ("NE Quadrant", "Oscar", 1);
        firstSightings.save();
        Sightings secondSightings = new Sightings ("NE Quadrant", "Oscar", 1);
        secondSightings.save();
        assertEquals(Sightings.find(secondSightings.getId()), secondSightings);
    }

    @Test
    public void save_savesAnimalIdIntoDB_true(){
        Animal testAnimal = new Animal("Monkey");
        testAnimal.save();
        Sightings testSightings = new Sightings("NE Quadrant", "Oscar",testAnimal.getId());
        testSightings.save();
        Sightings savedSightings = Sightings.find(testSightings.getId());
        assertEquals(savedSightings.getAnimalId(), testAnimal.getId());
    }

    @Test
    public void save_recordsTimeOfSightingInDatabase() {
        Sightings testSightings = new Sightings("NE Quadrant", "Oscar", 1);
        testSightings.save();
        Timestamp savedSightingTime = Sightings.find(testSightings.getId()).getSighting();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getDay(), savedSightingTime.getDay());
    }

}