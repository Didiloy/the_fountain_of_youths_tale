package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;

public class Astronomiya extends Location {
    public Astronomiya(String name) {
        super(name);
        this.character = new NPCharacter("Galilo", Speciality.ASTRONOMY);

    }

    @Override
    public void createExits() {
        this.exits.replace("Zounkla", true);
        this.exits.replace("Dimidium", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("story"));
        fillChoice();
        switch (this.choice) {
            case YES -> {
                System.out.println(this.lore.get("ca_0"));
                return;
//                    printCharByChar(this.lore.get("ce1_0"));
            }
            case NO -> {
                System.out.println(this.lore.get("ca_1"));
                fillChoice();
                switch (this.choice) {
                    case YES -> {
                        System.out.println(this.lore.get("ca_1_0"));
//                        p.add_crew(new NPCharacter("Bread Grills", Speciality.FOOD));
                    }
                    case NO -> System.out.println(this.lore.get("ca_1_1"));
                }
                System.out.println(this.lore.get("story_2"));
                fillChoice();
                switch (this.choice) {
                    case YES -> {
                        System.out.println(this.lore.get("ca_2"));
                        p.add_crew(this.character);
                    }
                    case NO -> {
                        System.out.println(this.lore.get("ca_3"));
                        fillChoice();
                        switch (this.choice) {
                            case YES -> {
                                System.out.println(this.lore.get("ca_3_0"));
                                p.add_crew(this.character);
                            }
                            case NO -> {
                                System.out.println(this.lore.get("ca_3_1"));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }


}
