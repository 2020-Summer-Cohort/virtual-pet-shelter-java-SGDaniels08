package shelter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetShelterTest {
    @Test
    public void checkPetShelterMapWorks() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.");
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        Map<String, VirtualPet> testInhabitants = testShelter.retrieveAllPets();

        assertEquals(3, testInhabitants.size());
    }

    @Test
    public void checkPetShelterMapIsEmpty() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.");
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        Map<String, VirtualPet> testInhabitants = testShelter.retrieveAllPets();

        assertTrue(testInhabitants.isEmpty());
    }

    @Test
    public void checkGetPetByName() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.");
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        VirtualPet testPet = testShelter.getPet("Goruk");

        assertEquals("Goruk", testPet.getName());
    }

    @Test
    public void checkGetPetByDescription() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.");
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        VirtualPet testPet = testShelter.getPet("Miznob");

        assertEquals(" is looking in 2.5 directions at the same time.", testPet.getDescription());
    }

    @Test
    public void checkAdoptPet() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.");
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        testShelter.adoptPet("Zarflak");

        assertEquals(false, testShelter.contains("Zarflak"));
    }

    @Test
    public void checkAllPetsEat() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 20, 60);
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        testShelter.allPetsEat();

        assertEquals(0, testPet1.getHunger());
        assertEquals(0, testPet2.getHunger());
        assertEquals(0, testPet3.getHunger());
    }

    @Test
    public void checkAllPetsDrink() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 20, 60);
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        testShelter.allPetsDrink();

        assertEquals(0, testPet1.getThirst());
        assertEquals(0, testPet2.getThirst());
        assertEquals(0, testPet3.getThirst());
    }

    @Test
    public void checkPlayOnePet() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 86, 60);
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        testShelter.playWith(testPet2);

        assertEquals(36, testPet2.getBoredom());
    }

    @Test
    public void checkFightWithMethod() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 86, 60);
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        testShelter.fightWith(testPet2.getName(), testPet1.getName());

        assertEquals(0, testPet1.getAggression());
        assertEquals(10, testPet2.getAggression());
        assertEquals(50, testPet3.getAggression());
    }

    @Test
    public void checkTickMethod() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 86, 60);
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        testShelter.tick();

        assertEquals(50, testPet1.getAggression());
        assertEquals(60, testPet1.getHunger());
        assertEquals(91, testPet2.getBoredom());
    }

    @Test
    public void checkSixRunsTickMethod() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet testPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 86, 60);
        VirtualPet testPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        testShelter.intakePet(testPet1);
        testShelter.intakePet(testPet2);
        testShelter.intakePet(testPet3);

        for (int i = 0; i < 6; i++) {
            testShelter.tick();
        }

        assertEquals(50, testPet1.getAggression());
        assertEquals(100, testPet1.getHunger());
        assertEquals(100, testPet2.getBoredom());
    }
}
