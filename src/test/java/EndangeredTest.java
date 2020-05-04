import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredanimal_instantiatesCorrectly_true() {
        Endangered testEndangered = new Endangered("White Rhino", "Healthy", "Adult");
        assertEquals(true, testEndangered instanceof Endangered);
    }

    @Test
    public void equals_returnsTrueIfNameAndIdAreSame_true() {
        Endangered firstEndangered = new Endangered("White Rhino", "Healthy", "Adult");
        Endangered anotherEndangered = new Endangered("White Rhino", "Healthy", "Adult");
        assertTrue(firstEndangered.equals(anotherEndangered));
    }


    @Test
    public void all_returnsAllInstancesOfEndangered_false() {
        Endangered firstEndangered = new Endangered("White Rhino", "Healthy", "Adult");
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Hirola", "Okay", "Newborn");
        secondEndangered.save();
        assertEquals(false, Endangered.all().get(0).equals(firstEndangered));
        assertEquals(false, Endangered.all().get(1).equals(secondEndangered));
    }

    @Test
    public void save_assignsIdToObject() {
        Endangered testEndangered = new Endangered("White Rhino", "Healthy", "Adult");
        testEndangered.save();
        Endangered savedEndangered = Endangered.all().get(0);
        assertEquals(testEndangered.getId(), savedEndangered.getId());
    }


    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        Endangered testEndangered = new Endangered("White Rhino", "Healthy", "Adult");
        testEndangered.save();
        Sightings firstSightings = new Sightings("SE Quadrant", "Paula", testEndangered.getId());
        firstSightings.save();
        Sightings secondSightings = new Sightings("NW Quadrant", "Jacob", testEndangered.getId());
        secondSightings.save();
        Sightings[] sightings = new Sightings[] { firstSightings, secondSightings };
        assertTrue(testEndangered.getSightings().containsAll(Arrays.asList(sightings)));
    }


}