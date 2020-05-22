package shelter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

    private Map<String, VirtualPet> shelterInhabitants = new HashMap<>();

    public Map<String, VirtualPet> retrieveAllPets() {
        return shelterInhabitants;
    }
    public VirtualPet getPet(String name) {
        return shelterInhabitants.get(name);
    }

    public void allPetsEat() {
        for (Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toFeed = entry.getValue();
            toFeed.eat();
        }
    }
    public void allPetsDrink() {
        for (Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toWater = entry.getValue();
            toWater.drink();
        }
    }
    public void playWith(VirtualPet playPet) {
        playPet.play();
    }
    public void fightWith(String petName1, String petName2) {
        VirtualPet fighter1 = shelterInhabitants.get(petName1);
        VirtualPet fighter2 = shelterInhabitants.get(petName2);

        fighter1.fight();
        fighter2.fight();
    }

    public void intakePet(VirtualPet takenIn) {
        shelterInhabitants.put(takenIn.getName(), takenIn);
    }
    public void adoptPet(String name) {
        shelterInhabitants.remove(name);
    }
    public boolean contains(String name) {
        return shelterInhabitants.containsKey(name);
    }
    public boolean isEmpty() {
        return shelterInhabitants.isEmpty();
    }

    public void tick() {
        for (Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet tickPet = entry.getValue();
            tickPet.tick();
        }
    }
}
