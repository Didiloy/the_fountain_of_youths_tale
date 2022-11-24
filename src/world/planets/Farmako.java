package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Farmako extends Location {
    public Farmako(String name) {
        super(name);
        this.character = new NPCharacter("Pastor", Speciality.MEDICINE);
    }
}
