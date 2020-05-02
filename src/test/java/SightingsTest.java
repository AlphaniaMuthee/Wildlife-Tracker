import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightings_InstantiatesCorrectly_true() {
        Sightings testSightings = new Sightings ("NE Quadrant", 1);
        assertEquals(true, testSightings instanceof Sightings );
    }

    @Test
    public void sightings_instantiateWithLocation_String(){
        Sightings testSightings = new Sightings ("NE Quadrant", 1);
        assertEquals("NE Quadrant", testSightings.getLocation());
    }

    @Test
    public void sightings_instantiateWithAnimalId_int(){
        Sightings testSightings = new Sightings("NE Quadrant", 1);
        assertEquals(1, testSightings.getAnimalId());
    }

    @Test
    public void equals_returnsTrueIfLocationAndAnimalIdAreSAme_true() {
        Sightings testSightings = new Sightings ("NE Quadrant", 1);
        Sightings anotherSightings = new Sightings ("NE Quadrant", 1);
        assertTrue(testSightings.equals(anotherSightings));
    }

}