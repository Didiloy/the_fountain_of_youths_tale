package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import character.Player;
import world.Location;

public class Enoplos extends Location {
    public Enoplos(String name) {
        super(name);
        this.character = new NPCharacter("Rambaw", Speciality.WEAPON);
    }

    @Override
    public void createExits() {
        this.exits.replace("Astronomiya", true);
        this.exits.replace("Dimidium", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("story"));
        fillChoice(new String[]{"go", "look"});
        switch (this.choice) {
            case GO -> {
                System.out.println(this.lore.get("ce_0"));
                fillChoice(new String[]{"look", "go"});
                switch (this.choice) {
                    case LOOK -> {
                        System.out.println(this.lore.get("ce_0_0"));
                        fillChoice(new String[]{"yes", "no"});
                        switch (this.choice) {
                            case YES -> {
                                System.out.println(this.lore.get("ce_0_0_0"));
                                p.add_crew(this.character);
                            }
                            case NO -> System.out.println(this.lore.get("ce_0_0_1"));
                        }
                    }
                    case GO -> System.out.println(this.lore.get("ce_0_1"));
                }
            }
            case LOOK -> System.out.println(this.lore.get("ce_1"));
        }
    }
}
