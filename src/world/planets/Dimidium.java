package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Dimidium extends Location {
    //TODO

    public Dimidium(String name) {
        super(name);
        this.character = new NPCharacter("None", Speciality.NONE);

    }
}
