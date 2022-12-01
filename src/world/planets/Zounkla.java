package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;



public class Zounkla extends Location {
    public Zounkla(String name) {
        super(name);
        this.character = new NPCharacter("Diana", Speciality.FOOD);

    }

    @Override
    public void createExits() {
        this.exits.replace("Enoplos", true);
        this.exits.replace("Dimidium", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        if (cameFrom.equals("Earth")) {
            System.out.println(this.lore.get("storyFromEarth"));
//            printCharByChar(this.lore.get("storyFromEarth"));
            fillChoice(new String[]{"yes", "no"});
            switch (this.choice) {
                case YES:
                    System.out.println(this.lore.get("ce1_0"));
                    break;
                case NO:
                    System.out.println(this.lore.get("ce1_1"));
                    break;
            }
            System.out.println(this.lore.get("ce1_story"));
            fillChoice(new String[]{"yes", "no"});
            switch (this.choice) {
                case YES:
                    System.out.println(this.lore.get("ce2_0"));
                    p.add_crew(this.character);
                    break;
                case NO:
                    System.out.println(this.lore.get("ce2_1"));
                    break;
            }
        } else {
            System.out.println(this.lore.get("storyFromAstronomiya"));
            fillChoice(new String[]{"yes", "no"});
            switch (this.choice) {
                case YES -> {
                    System.out.println(this.lore.get("ca1_0"));
//                    printCharByChar(this.lore.get("ce1_0"));
                    fillChoice(new String[]{"yes", "no"});
                    switch (this.choice) {
                        case YES -> {
                            System.out.println(this.lore.get("ca1_0_0"));
                            p.add_crew(new NPCharacter("Bread Grills", Speciality.FOOD));
                        }
                        case NO -> System.out.println(this.lore.get("ca1_0_1"));
                    }
                }
                case NO -> System.out.println(this.lore.get("ca1_1"));
            }
        }

    }
}
