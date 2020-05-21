package shelter;

public class VirtualPet {

    private String name;
    private String description;
    private int hunger;
    private int thirst;
    private int boredom;
    private int aggression;

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
        hunger = 50;
        thirst = 50;
        boredom = 50;
        aggression = 50;
    }
    public VirtualPet(String name, String description, int hunger, int thirst, int boredom, int aggression){
        this.name = name;
        this.description = description;
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
        this.aggression = aggression;
    }

    public void tick() {
        hunger += 10;
        thirst += 10;
        boredom += 5;
    }

    public void eat() {
        hunger = 0;
    }
    public void drink() {
        thirst = 0;
    }
    public void play() {
        boredom -= 50;
        if (boredom < 0) {
            boredom = 0;
        }
    }
    public void fight() {
        aggression -= 50;
        if (aggression < 0) {
            aggression = 0;
        }
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getHunger() {
        return hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public int getBoredom() {
        return boredom;
    }
    public int getAggression() {
        return aggression;
    }
}
