package shelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void checkVirtualPetDefaultConstructor() {
        VirtualPet testPet = new VirtualPet("Zarflak", " smells like a goblin should.");
        assertEquals(50, testPet.getThirst());
    }
    @Test
    public void checkVirtualPetExplicitConstructor() {
        VirtualPet testPet = new VirtualPet("Zarflak", " smells like a goblin should.",
                50, 55, 20, 60);
        assertEquals(55, testPet.getThirst());
        assertEquals(60, testPet.getAggression());
    }
    @Test
    public void checkEatMethod() {
        VirtualPet testPet = new VirtualPet("Zarflak", " smells like a gobling should.");
        testPet.eat();
        assertEquals(0, testPet.getThirst());
    }
    @Test
    public void checkDrinkMethod() {
        VirtualPet testPet = new VirtualPet("Zarflak", " smells like a gobling should.");
        testPet.drink();
        assertEquals(0, testPet.getThirst());
    }
    @Test
    public void checkPlayAndFightMethods() {
        VirtualPet testPet = new VirtualPet("Zarflak", " smells like a goblin should.",
                50, 55, 20, 60);
        testPet.play();
        testPet.fight();
        assertEquals(0, testPet.getBoredom());
        assertEquals(10, testPet.getAggression());
    }
    @Test
    public void checkTickMethod() {
        VirtualPet testPet = new VirtualPet("Zarflak", " smells like a goblin should.",
                50, 55, 20, 60);
        testPet.tick();
        assertEquals(60, testPet.getThirst());
        assertEquals(65, testPet.getThirst());
        assertEquals(25, testPet.getBoredom());
        assertEquals(60, testPet.getAggression());
    }
}
