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

        } else {
            System.out.println(this.lore.get("storyFromAstronomiya"));
            fillChoice();
            switch (this.choice) {
                case YES:
                    System.out.println(this.lore.get("ca1_0"));
//                    printCharByChar(this.lore.get("ce1_0"));
                    fillChoice();
                    switch(this.choice){
                        case YES:
                            System.out.println(this.lore.get("ca1_0_0"));
                            p.add_crew(new NPCharacter("Bread Grills", Speciality.FOOD));
                            break;
                        case NO:
                            System.out.println(this.lore.get("ca1_0_1"));
                            break;
                    }
                    break;
                case NO:
                    System.out.println(this.lore.get("ca1_1"));
                    break;
            }
        }

    }
}
