package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
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
    public void tellStory() {

    }
}
