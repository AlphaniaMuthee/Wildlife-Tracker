import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Monkey", 1);
        assertEquals(true, testAnimal instanceof Animal);
    }

}