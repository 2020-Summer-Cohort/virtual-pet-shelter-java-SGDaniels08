package shelter;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Start condition for Virtual Pet Shelter
        VirtualPetShelter goblinShelter = new VirtualPetShelter();
        VirtualPet goblinPet1 = new VirtualPet("Zarflak", " smells like a goblin should.");
        VirtualPet goblinPet2 = new VirtualPet("Goruk", " looks like roadkill stew.",
                75, 55, 86, 60);
        VirtualPet goblinPet3 = new VirtualPet("Miznob", " is looking in 2.5 directions at the same time.");

        goblinShelter.intakePet(goblinPet1);
        goblinShelter.intakePet(goblinPet2);
        goblinShelter.intakePet(goblinPet3);

        int choice;
        boolean keepGobbing = true;

        while (keepGobbing) {
            System.out.println("Welcome to our Virtual Goblin Pet Shelter!");
            System.out.println("What would you like to do here today?\n");
            displayPets(goblinShelter);
            displayShelterMenu();
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) { keepGobbing = false; }
            else if (choice == 1) { goblinShelter.allPetsEat(); }
            else if (choice == 2) { goblinShelter.allPetsDrink(); }
            else if (choice == 3) {
                System.out.println("Who do you want to play with?");
                displayPetNamesAndDescriptions(goblinShelter);
                System.out.print("Enter the [ name ] of the goblin you want: ");
                String name = input.nextLine();
                if (goblinShelter.contains(name)) {
                    VirtualPet playPet = goblinShelter.getPet(name);
                    playPet.play();
                } else {
                    System.out.println("Uh, we don't have that one here. Let's start over...");
                    continue;
                }
            }
            else if (choice == 4) {
                System.out.println("Which two goblins are you sending to the arena?");
                displayPetNamesAndDescriptions(goblinShelter);
                System.out.print("Enter the [ name ] of Fighter 1 : ");
                String fighter1 = input.nextLine();
                System.out.print("Enter the [ name ] of Fighter 2 : ");
                String fighter2 = input.nextLine();
                if (fighter1.equals(fighter2)) {
                    System.out.println(fighter1 + " can't fight itself! Let's start over.");
                } else if (goblinShelter.contains(fighter1) && goblinShelter.contains(fighter2)) {
                    goblinShelter.fightWith(fighter1, fighter2);
                } else {
                    System.out.println("At least one of those goblins isn't here. Let's start over...");
                    continue;
                }
            }
            else if (choice == 5) {
                System.out.println("Thank you for your decision! Which pet do you want to adopt?");
                displayPetNamesAndDescriptions(goblinShelter);
                System.out.print("Enter the [ name ] of the goblin you want: ");
                String adopted = input.nextLine();
                if (goblinShelter.contains(adopted)) {
                    System.out.println("Thank you for adopting " + adopted + "!");
                    goblinShelter.adoptPet(adopted);
                } else {
                    System.out.println("Uh, we don't have that one here. Let's start over...");
                    continue;
                }
            }
            else if (choice == 6) {
                System.out.println("So you want to donate a pet? Tell me about the little scamp!");
                System.out.print("Name? --> ");
                String name = input.nextLine();
                System.out.print("Description? --> ");
                String description = input.nextLine();
                VirtualPet newPet = new VirtualPet(name, description);
                goblinShelter.intakePet(newPet);
            }
            else {
                System.out.println("Invalid choice, let's try again.");
                continue;
            }

            if (goblinShelter.isEmpty()) {
                keepGobbing = false;
                continue;
            }
            goblinShelter.tick();
        }
    }

    /*
     *      Methods for main()
     */

    public static void displayShelterMenu() {
        System.out.println("1 : Feed goblins");
        System.out.println("2 : Water goblins");
        System.out.println("3 : Play with one goblin (choose one)");
        System.out.println("4 : Have two goblins fight (burns off energy!)");
        System.out.println("5 : Adopt a goblin -- take one home today!");
        System.out.println("6 : Donate a goblin -- add it to the shelter!");
        System.out.println("0 : Leave");
        System.out.print("Choose --> ");
    }

    public static void displayPets(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();
        for (Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            System.out.println("NAME\t\tHunger\tThirst\tBoredom\tAggression");
            System.out.print(petToShow.getName() + "\t\t");
            System.out.print(petToShow.getHunger() + "\t\t");
            System.out.print(petToShow.getThirst() + "\t\t");
            System.out.print(petToShow.getBoredom() + "\t\t");
            System.out.print(petToShow.getAggression() + "\n\n");
        }
    }

    private static void displayPetNames(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();
        for (Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            System.out.println("[ " + petToShow.getName() + " ]");
        }
    }

    private static void displayPetNamesAndDescriptions(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();
        for (Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            System.out.println("[ " + petToShow.getName() + " ]" + petToShow.getDescription());
        }
    }
}
