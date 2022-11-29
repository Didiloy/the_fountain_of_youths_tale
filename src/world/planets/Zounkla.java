package world.planets;

import character.NPCharacter;
import common.enums.Argument;
import common.enums.Speciality;
import common.input.IncorrectNumberOfParameterException;
import common.input.UnrecognizableArgumentException;
import player.Player;
import world.Location;

import java.util.Map;

import static common.input.parseArg.parseAnswer;
import static common.input.parseArg.parseArgs;
import static common.output.Out.printCharByChar;

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
            fillChoice();
            switch (this.choice) {
                case YES:
                    System.out.println(this.lore.get("ce1_0"));
//                    printCharByChar(this.lore.get("ce1_0"));
                case NO:
                    System.out.println(this.lore.get("ce1_1"));
                    break;
            }
            System.out.println(this.lore.get("ce1_story"));
            fillChoice();
            switch (this.choice) {
                case YES:
                    System.out.println(this.lore.get("ce2_0"));
                    p.add_crew(this.character);
//                    printCharByChar(this.lore.get("ce1_0"));
                case NO:
                    System.out.println(this.lore.get("ce2_1"));
                    break;
            }
        } else {
            System.out.println(this.lore.get("storyFromAstronomiya"));
            fillChoice();
            switch (this.choice) {
                case YES -> {
                    System.out.println(this.lore.get("ca1_0"));
//                    printCharByChar(this.lore.get("ce1_0"));
                    fillChoice();
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
