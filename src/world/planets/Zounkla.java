package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import common.input.IncorrectNumberOfParameterException;
import common.input.UnrecognizableArgumentException;
import world.Location;

import static common.input.parseArg.parseAnswer;

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
    public void tellStory() {
        System.out.println(this.lore.get("storyFromEarth"));
        System.out.println("make a choice 0 or 1:");
        int choice = -1;
        while (choice == -1) {
            try {
                choice = parseAnswer();
            } catch (UnrecognizableArgumentException | IncorrectNumberOfParameterException e) {
                System.out.println("You must enter a number between 0 and 1");
            }
        }
        switch (choice) {
            case 0:
                System.out.println(this.lore.get("choice1_0"));
                break;
            case 1:
                System.out.println(this.lore.get("choice1_1"));
                break;
        }
    }
}
